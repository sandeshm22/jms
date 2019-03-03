package org.ds.server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {

    private ServerSocket serverSocket;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);

    }


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if (serverSocket != null) {
            serverSocket.close();
        }
    }

    public void run() {
        Socket socket = null;
        while (true) {
            try {
                socket = serverSocket.accept();
                new ClientHandler(socket).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
