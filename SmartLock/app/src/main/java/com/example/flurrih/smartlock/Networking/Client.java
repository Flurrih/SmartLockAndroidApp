package com.example.flurrih.smartlock.Networking;

import java.io.DataOutputStream;
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
            this.socket = new Socket(InetAddress.getByName("145.239.89.185"), 8081);
            DataOutputStream outToServer =
                    new DataOutputStream(socket.getOutputStream());

            System.out.print("Command : ");
            //outToServer.writeInt(1);
            outToServer.writeUTF("dupa");
            outToServer.write(toBytes(66789));
            outToServer.flush();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }

        return socket.isConnected();
    }

    byte[] toBytes(int i)
    {
        byte[] result = new byte[4];

        result[0] = (byte) (i >> 24);
        result[1] = (byte) (i >> 16);
        result[2] = (byte) (i >> 8);
        result[3] = (byte) (i /*>> 0*/);

        return result;
    }
}