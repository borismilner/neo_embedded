package server.handlers;

public class Response {
    public static final String OK = "ok";
    public static final String PORT_ALREADY_EXISTS = "port_already_exists";
    public static final String PORT_IS_MISSING = "No record of a neo4j process on port";
    public static final String PONG = "pong";
    public static final int OK_200 = 200;
    public static final int ERROR_400 = 400;

    private Response() {
    }
}
