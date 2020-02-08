package server.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import server.ServerManager;
import server.Utilities;

import java.io.IOException;

public class TerminateHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        Utilities.sendResponse("Goodbye!", httpExchange);
        ServerManager.embeddedRestServer.stop(0);
        ServerManager.terminate();
    }
}
