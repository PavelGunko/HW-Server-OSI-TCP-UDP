package org.example;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String... args) throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(ServerConfig.PORT)) {
            /* порт можете выбрать любой в доступном диапазоне 0-65536. Но чтобы не нарваться
            на уже занятый - рекомендуем использовать около 8080*/
            System.out.println("Сервис запущен");
            while (true) {

                try (Socket client = serverSocket.accept(); // ждем подключения
                     PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
                    // ваш код
                    System.out.println("New connection accepted " + client.getPort());

                    out.println("Вы подключены к серверу");

                    System.out.println(in.readLine());
                    final String name = in.readLine();
                    out.println(String.format("Hi %s, your port is %d", name, client.getPort()));


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}





