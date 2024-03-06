package org.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HttpResponse {
    public static void sendHtmlResponse(BufferedWriter writer, String filename) throws IOException {
        String content = readFileContent(filename);
        sendResponse(writer, "text/html", content);
    }

    public static void sendJsonResponse(BufferedWriter writer, String filename) throws IOException {
        String content = readFileContent(filename);
        sendResponse(writer, "application/json", content);
    }

    public static void sendNotFoundResponse(BufferedWriter writer) throws IOException {
        writer.write("HTTP/1.1 404 Not Found\r\n");
        writer.write("\r\n");
        writer.flush();
    }

    private static void sendResponse(BufferedWriter writer, String contentType, String content) throws IOException {
        writer.write("HTTP/1.1 200 OK\r\n");
        writer.write("Content-Type: " + contentType + "\r\n");
        writer.write("\r\n");
        writer.write(content);
        writer.flush();
    }

    private static String readFileContent(String filename) throws IOException {
        Path path = Paths.get(filename);
        return new String(Files.readAllBytes(path));
    }

    public static void sendTextResponse(BufferedWriter writer, String content) throws IOException {
        sendResponse(writer, "text/plain", content);
    }
}
