package com.example.charstream;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CharStreamDemo1 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("test.txt");
        int ch;
        while ((ch = fileReader.read()) != -1) {
            System.out.print((char) ch);
        }
        fileReader.close();
    }
}
