package server.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import logging.LogHelper;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.OutputStream;

public class PingHandler implements HttpHandler {

    private static Logger log = LogHelper.getLogger();

    @Override
    public void handle(HttpExchange t) throws IOException {
        String response = Response.PONG;
        log.debug("Got ping, ponging back.");
        t.sendResponseHeaders(Response.OK_200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
