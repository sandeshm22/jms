package org.ds.server;

import java.io.*;
import java.net.Socket;

import static java.lang.System.out;

public class ClientHandler extends Thread {

    private Socket socket;

    public ClientHandler(Socket theSocket) {
        this.socket = theSocket;
    }

    public void run() {
        try {
            System.out.print("client Handler started");
            DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String line = "";
            while (!line.equals("Over")) {
                line = in.readUTF();
                System.out.println(line);
            }
            System.out.println("Closing connection");
            socket.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
