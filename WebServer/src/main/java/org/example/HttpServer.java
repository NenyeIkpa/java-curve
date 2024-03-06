package org.example;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        try (
                ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new HttpRequestHandler(clientSocket).start();
            }
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

}
