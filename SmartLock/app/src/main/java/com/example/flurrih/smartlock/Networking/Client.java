package com.example.flurrih.smartlock.Networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    private static Client INSTANCE;
    private Socket socket;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;

    private Client() {

    }

    public static Client getInstance(){
        if(INSTANCE == null)
            INSTANCE = new Client();
        return INSTANCE;
    }

    public boolean connectToServer(){
        try {
            this.socket = new Socket(InetAddress.getByName("54.37.232.177"), 8818);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return socket.isConnected();
    }
}