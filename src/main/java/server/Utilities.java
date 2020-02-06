package server;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Utilities {
    private static StringBuilder sb;

    public static int getPort(HttpExchange incoming) {
        InputStream requestBody = incoming.getRequestBody();
        int character = 0;
        sb = new StringBuilder();
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
        Integer portValue = Integer.valueOf(sb.toString());
        return portValue;
    }

    public static void sendResponse(String response, HttpExchange httpExchange) throws IOException {
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream outputStream = httpExchange.getResponseBody();
        outputStream.write(response.getBytes());
        outputStream.close();
    }
}
