package org.example;

import java.io.*;
import java.net.Socket;

public class HttpRequestHandler extends Thread {
    private final Socket clientSocket;

    public HttpRequestHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(
                     new OutputStreamWriter(clientSocket.getOutputStream()))) {

            String request = reader.readLine();
            String[] requestParts = request.split(" ");

            if (requestParts.length != 3) {
                // Invalid request format
                sendBadRequestResponse(writer);
                return;
            }

            String method = requestParts[0];
            String path = requestParts[1];

            switch (method) {
                case "GET":
                    handleGetRequest(writer, path);
                    break;
                case "POST":
                    handlePostRequest(reader, writer, path);
                    break;
                case "PUT":
                    handlePutRequest(reader, writer, path);
                    break;
                case "PATCH":
                    handlePatchRequest(reader, writer, path);
                    break;
                default:
                    // Unsupported method
                    sendMethodNotAllowedResponse(writer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleGetRequest(BufferedWriter writer, String path) throws IOException {
        if ("/".equals(path)) {
            HttpResponse.sendHtmlResponse(writer, "index.html");
        } else if ("/json".equals(path)) {
            HttpResponse.sendJsonResponse(writer, "data.json");
        } else {
            HttpResponse.sendNotFoundResponse(writer);
        }
    }

    private void handlePostRequest(BufferedReader reader, BufferedWriter writer, String path) throws IOException {
        // Handle POST request logic here
        // Example: Read the request body and perform actions accordingly
        String requestBody = readRequestBody(reader);
        String response = "Received POST request with body: " + requestBody;
        HttpResponse.sendTextResponse(writer, response);
    }

    private void handlePutRequest(BufferedReader reader, BufferedWriter writer, String path) throws IOException {
        // Handle PUT request logic here
        // Example: Read the request body and perform actions accordingly
        String requestBody = readRequestBody(reader);
        String response = "Received PUT request with body: " + requestBody;
        HttpResponse.sendTextResponse(writer, response);
    }

    private void handlePatchRequest(BufferedReader reader, BufferedWriter writer, String path) throws IOException {
        // Handle PATCH request logic here
        // Example: Read the request body and perform actions accordingly
        String requestBody = readRequestBody(reader);
        String response = "Received PATCH request with body: " + requestBody;
        HttpResponse.sendTextResponse(writer, response);
    }

    private String readRequestBody(BufferedReader reader) throws IOException {
        StringBuilder requestBody = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            requestBody.append(line).append("\n");
        }
        return requestBody.toString().trim();
    }

    private void sendBadRequestResponse(BufferedWriter writer) throws IOException {
        writer.write("HTTP/1.1 400 Bad Request\r\n\r\n");
        writer.flush();
    }

    private void sendMethodNotAllowedResponse(BufferedWriter writer) throws IOException {
        writer.write("HTTP/1.1 405 Method Not Allowed\r\n\r\n");
        writer.flush();
    }
}
