package server;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Utilities {

    private Utilities() {
    }

    public static int getPort(HttpExchange incoming) {
        InputStream requestBody = incoming.getRequestBody();
        int character;
        StringBuilder sb = new StringBuilder();
        do {
            try {
                character = requestBody.read();
                if (character == -1) {
                    break;
                }
                sb.append((char) character);
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        while (true);
        return Integer.parseInt(sb.toString());
    }

    public static void sendResponse(String response, HttpExchange httpExchange, int status) throws IOException {
        httpExchange.sendResponseHeaders(status, response.length());
        OutputStream outputStream = httpExchange.getResponseBody();
        outputStream.write(response.getBytes());
        outputStream.close();
    }
}
