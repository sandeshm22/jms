package org.ds.client;

import org.ds.server.Client;

public class Main {


    public static void main(String[] args) {
        for(int i = 0 ; i< 10; i++){
            Client client = new Client("127.0.0.1", 9999);
            client.start();
        }
    }
}
