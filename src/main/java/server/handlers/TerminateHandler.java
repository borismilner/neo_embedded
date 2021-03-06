package server.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import server.ServerManager;
import server.Utilities;

import java.io.IOException;

public class TerminateHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        Utilities.sendResponse("Terminating - goodbye.", httpExchange, Response.OK_200);
        ServerManager.stopRestServer();
        ServerManager.terminate();
    }
}
