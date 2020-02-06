package server.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import server.ServerManager;
import server.Utilities;

import java.io.IOException;

public class StartHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        int port = Utilities.getPort(httpExchange);
        String response = ServerManager.startEmbeddedNeo(port);
        Utilities.sendResponse(response, httpExchange);
    }
}
