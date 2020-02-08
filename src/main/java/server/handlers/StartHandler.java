package server.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.apache.logging.log4j.Logger;
import logging.LogHelper;
import server.ServerManager;
import server.Utilities;

import java.io.IOException;

public class StartHandler implements HttpHandler {

    private static Logger log = LogHelper.getLogger();

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        int port = Utilities.getPort(httpExchange);
        String response = ServerManager.startEmbeddedNeo(port);
        if (response != Response.OK) {
            log.error(response);
        }
        else {
            log.debug(String.format("Neo4j started on port %d", port));
        }
        Utilities.sendResponse(response, httpExchange);
    }
}
