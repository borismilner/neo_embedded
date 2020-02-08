package server.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import logging.LogHelper;
import org.apache.logging.log4j.Logger;
import server.ServerManager;
import server.Utilities;

import java.io.IOException;

public class StopHandler implements HttpHandler {

    private static Logger log = LogHelper.getLogger();

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        int port = Utilities.getPort(httpExchange);
        String response = ServerManager.stopEmbeddedNeo(port);
        if (!response.equals(Response.OK)) {
            log.error(response);
            Utilities.sendResponse(response, httpExchange, Response.ERROR_400);
        }
        else {
            log.debug(String.format("Neo4j stopped on port %d", port));
            Utilities.sendResponse(response, httpExchange, Response.OK_200);
        }

    }
}
