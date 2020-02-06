package server.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import server.ServerManager;
import server.Utilities;

import java.io.IOException;

public class StopAllHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String response = ServerManager.stopAll();
        Utilities.sendResponse(response, httpExchange);
        ServerManager.embeddedRestServer.stop(0);

    }
}
