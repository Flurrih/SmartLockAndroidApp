package com.example.flurrih.smartlock.Networking;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class SmartLockClient {

    private Socket socket;
    private Scanner scanner;

    public SmartLockClient() throws Exception {
        this.socket = new Socket(InetAddress.getByName("54.37.232.177"), 8818);
        this.scanner = new Scanner(System.in);
    }

    public void start() throws IOException {
        String input;
        while (true) {
            input = scanner.nextLine();
            PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
            out.println(input);
            out.flush();
        }
    }
}
