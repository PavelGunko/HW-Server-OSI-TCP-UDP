package org.example;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String... args) {


        try (Socket clientSocket = new Socket(ServerConfig.HOST, ServerConfig.PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            System.out.println(in.readLine());
            out.println("Hello World");

            out.println("Petya");
            String name = in.readLine();
            System.out.println(name);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
