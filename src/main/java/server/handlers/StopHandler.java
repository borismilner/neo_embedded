package server.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import server.ServerManager;
import server.Utilities;

import java.io.IOException;
import java.io.OutputStream;

public class StopHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        int port = Utilities.getPort(httpExchange);
        String response = ServerManager.stopEmbbededNeo(port);
        Utilities.sendResponse(response, httpExchange);

    }
}
