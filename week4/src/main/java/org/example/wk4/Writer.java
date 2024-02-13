package org.example.wk4;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    public static void main(String[] args) {
        System.out.println("Hello world!");


        String desktopPath = System.getProperty("user.home") + "/Desktop";
        System.out.println(desktopPath);
        try {
            java.io.Writer wr = new FileWriter(desktopPath + "/output.csv");
            String content = "I am learning to write to a CSV file";
            wr.write(content);
            wr.close();
            System.out.println("Success!");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
