package server;

import com.sun.net.httpserver.HttpServer;
import org.neo4j.harness.ServerControls;
import org.neo4j.harness.TestServerBuilders;
import server.handlers.PingHandler;
import server.handlers.StartHandler;
import server.handlers.StopAllHandler;
import server.handlers.StopHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

public class ServerManager {

    private static final String OK = "ok";
    private static final String GOODBYE = "goodbye!";

    public static HttpServer embeddedRestServer;

    private static HashMap<Integer, ServerControls> mapPortToServer = new HashMap<>();

    public static void main(String[] args) {
        boolean startedRestServer = startRestServer();
        if (!startedRestServer) {
            throw new RuntimeException("Failed starting REST server");
        }
    }

    public static boolean startRestServer() {
        try {
            embeddedRestServer = HttpServer.create(new InetSocketAddress(6666), 0);
        }
        catch (IOException e) {
            return false;
        }
        embeddedRestServer.createContext("/ping", new PingHandler());
        embeddedRestServer.createContext("/start", new StartHandler());
        embeddedRestServer.createContext("/stop", new StopHandler());
        embeddedRestServer.createContext("/stop_all", new StopAllHandler());
        embeddedRestServer.setExecutor(null); // creates a default executor
        embeddedRestServer.start();
        return true;
    }


    public static String startEmbeddedNeo(int port) {
        if (mapPortToServer.containsKey(port)) {
            return "already_exists";
        }
        try {
            String pluginsFolder = System.getProperty("user.dir") + "\\plugins\\";
            System.out.println(String.format("Expected plugins folder for the embedded neo-server - %s", pluginsFolder));
            ServerControls embeddedServer = TestServerBuilders.newInProcessBuilder()
                    .withConfig("dbms.connector.bolt.listen_address", String.format(":%d", port))
                    .withConfig("dbms.connector.bolt.enabled", "true")
                    .withConfig("dbms.logs.query.enabled", "true")
                    .withConfig("dbms.track_query_cpu_time", "true")
                    .withConfig("dbms.index.default_schema_provider", "lucene+native-2.0")
                    .withConfig("dbms.directories.plugins", pluginsFolder)
                    .newServer();
            mapPortToServer.put(port, embeddedServer);
        }
        catch (Exception exception) {
            return String.format("Error: %s", exception.getMessage());
        }
        return OK;
    }

    public static String stopEmbeddedNeo(int port) {
        if (!mapPortToServer.containsKey(port)) {
            return "missing_port";
        }
        mapPortToServer.get(port).close();
        mapPortToServer.remove(port);
        return OK;
    }

    public static void stopAll() {
        for (Map.Entry<Integer, ServerControls> entry : mapPortToServer.entrySet()) {
            entry.getValue().close();
        }
        System.exit(0);
    }
}
