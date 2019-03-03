package org.ds;

import org.ds.server.Server;

import java.io.IOException;

public class Main {

    private static final String SERVER_PORT = "org.ds.server.port";

    public static void main(String[] args) throws IOException {
        int port = Integer.parseInt(ApplicationPropertiesReader.getProperty(SERVER_PORT));
        Server server = new Server(port);
        Thread thread = new Thread(server);
        thread.start();
    }
}
