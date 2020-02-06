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

    public static ServerControls embeddedNeo4jServer;
    public static HttpServer embeddedRestServer;

    private static final String OK = "ok";
    private static final String GOODBYE = "goodbye!";
    private static HashMap<Integer, ServerControls> mapPortToServer = new HashMap<>();

    public static void main(String[] args) {
        startRestServer();
    }

    public static String startEmbeddedNeo() {
        return startEmbeddedNeo(7687);
    }

    public static String startEmbeddedNeo(int port) {
        if (mapPortToServer.containsKey(port)) {
            return "already_exists";
        }
        try {
            ServerControls embeddedServer = TestServerBuilders.newInProcessBuilder()
                    .withConfig("dbms.connector.bolt.listen_address", String.format(":%d", port))
                    .withConfig("dbms.connector.bolt.enabled", "true")
                    .withConfig("dbms.logs.query.enabled", "true")
                    .withConfig("dbms.track_query_cpu_time", "true")
                    .withConfig("dbms.index.default_schema_provider", "lucene+native-2.0")
                    // .withProcedure(Null) // A must step - to include a plugin
                    .newServer();
            mapPortToServer.put(port, embeddedServer);
        }
        catch (Exception exception) {
            return String.format("Error: %s", exception.getMessage());
        }
        return OK;
    }

    public static String stopEmbbededNeo(int port) {
        if (!mapPortToServer.containsKey(port)) {
            return "missing_port";
        }
        mapPortToServer.get(port).close();
        mapPortToServer.remove(port);
        return OK;
    }

    public static String stopAll() {
        for (Map.Entry<Integer, ServerControls> entry : mapPortToServer.entrySet()) {
            entry.getValue().close();
        }
        return GOODBYE;
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
}