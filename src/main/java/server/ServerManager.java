package server;

import com.sun.net.httpserver.HttpServer;
import logging.LogHelper;
import org.apache.logging.log4j.Logger;
import org.neo4j.harness.ServerControls;
import org.neo4j.harness.TestServerBuilder;
import org.neo4j.harness.TestServerBuilders;
import server.handlers.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

public class ServerManager {


    public static HttpServer embeddedRestServer;
    private static Logger log = LogHelper.getLogger();
    private static final int restServerPort = 2104;
    private static HashMap<Integer, ServerControls> mapPortToServer = new HashMap<>();

    public static void main(String[] args) {

        boolean startedRestServer = false;
        try {
            startedRestServer = startRestServer();
        }
        catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public static boolean startRestServer() throws IOException {
        embeddedRestServer = HttpServer.create(new InetSocketAddress(restServerPort), 0);
        embeddedRestServer.createContext("/start", new StartHandler());
        embeddedRestServer.createContext("/stop", new StopHandler());
        embeddedRestServer.createContext("/terminate", new TerminateHandler());
        embeddedRestServer.createContext("/ping", new PingHandler());
        embeddedRestServer.setExecutor(null); // creates a default executor
        embeddedRestServer.start();
        log.info(String.format("Listening for REST commands on port %d", restServerPort));
        return true;
    }


    public static String startEmbeddedNeo(int port) {
        if (mapPortToServer.containsKey(port)) {
            return Response.PORT_ALREADY_EXISTS;
        }
        try {
            String pwd = System.getProperty("user.dir");

            TestServerBuilder testServerBuilder = TestServerBuilders.newInProcessBuilder()
                    .withConfig("dbms.connector.bolt.listen_address", String.format(":%d", port));

            String configFileName = pwd + "/conf/neo4j.conf";
            File configFile = new File(configFileName);
            if (!configFile.exists() || configFile.isDirectory()) {
                log.error(String.format("%s does not exist - aborting.", configFileName));
                System.exit(-1);
            }
            log.info(String.format("Using configurations in %s", configFileName));
            BufferedReader bufferedReader = new BufferedReader(new FileReader(configFile));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String config = line.trim();
                if (config.startsWith("#") || config.isEmpty()) {
                    continue;
                }

                String[] keyValue = line.split("=");
                if (keyValue.length < 2) {
                    log.warn(String.format("Configuration line is ignored (expected key=value): %s", line));
                }
                else if (keyValue.length == 2) {
                    testServerBuilder = testServerBuilder.withConfig(keyValue[0].trim(), keyValue[1].trim());
                }
                else {
                    String value = line.substring(line.indexOf('=') + 1, line.length() - 1).trim();
                    testServerBuilder = testServerBuilder.withConfig(keyValue[0].trim(), value);
                }

            }

            ServerControls newServer = testServerBuilder.newServer();
            mapPortToServer.put(port, newServer);
        }
        catch (Exception exception) {
            return String.format("Error: %s", exception.getMessage());
        }
        return Response.OK;
    }

    public static String stopEmbeddedNeo(int port) {
        if (!mapPortToServer.containsKey(port)) {
            return String.format("%s: %d", Response.PORT_IS_MISSING, port);
        }
        mapPortToServer.get(port).close();
        mapPortToServer.remove(port);
        return Response.OK;
    }

    public static void terminate() {
        for (Map.Entry<Integer, ServerControls> entry : mapPortToServer.entrySet()) {
            entry.getValue().close();
        }
        System.exit(0);
    }
}
