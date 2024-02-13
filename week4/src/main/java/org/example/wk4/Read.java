package org.example.wk4;


import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Read {
    public static void main(String[] args) {
        String desktopPath = System.getProperty("user.home") + "/Desktop";


        try {
           Reader r = new FileReader(desktopPath + "/output.csv");
            int readContent = r.read();

            while (readContent != -1) {
                System.out.println((char)readContent);
                readContent = r.read();
            }
            r.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
