package server;

import com.sun.net.httpserver.HttpServer;
import logging.LogHelper;
import org.apache.logging.log4j.Logger;
import org.neo4j.harness.ServerControls;
import org.neo4j.harness.TestServerBuilder;
import org.neo4j.harness.TestServerBuilders;
import server.handlers.*;

import java.io.*;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

public class ServerManager {


    private static final int REST_SERVER_PORT = 2104;
    private static Logger log = LogHelper.getLogger();
    private static HttpServer embeddedRestServer;
    private static HashMap<Integer, ServerControls> mapPortToServer = new HashMap<>();

    public static void main(String[] args) {

        try {
            startRestServer();
        }
        catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public static void stopRestServer() {
        embeddedRestServer.stop(0);
    }

    public static void startRestServer() throws IOException {
        embeddedRestServer = HttpServer.create(new InetSocketAddress(REST_SERVER_PORT), 0);
        embeddedRestServer.createContext("/start", new StartHandler());
        embeddedRestServer.createContext("/stop", new StopHandler());
        embeddedRestServer.createContext("/terminate", new TerminateHandler());
        embeddedRestServer.createContext("/ping", new PingHandler());
        embeddedRestServer.setExecutor(null); // creates a default executor
        embeddedRestServer.start();
        log.info(String.format("Listening for REST commands on port %d", REST_SERVER_PORT));
    }


    public static String startEmbeddedNeo(int port) {
        if (mapPortToServer.containsKey(port)) {
            return Response.PORT_ALREADY_EXISTS;
        }

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
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(configFile))) {
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
        }
        catch (FileNotFoundException e) {
            log.error(String.format("File not found: %s", e.getMessage()));
        }
        catch (IOException e) {
            log.error(String.format("Failed closing buffered-reader: %s", e.getMessage()));
        }

        ServerControls newServer = testServerBuilder.newServer();
        mapPortToServer.put(port, newServer);


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
