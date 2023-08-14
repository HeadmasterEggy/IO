package com.example.charstream;

import java.io.FileReader;
import java.io.IOException;

public class CharStreamDemo2 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("test.txt");
        char[] chars = new char[2];
        int len;
        while((len = fileReader.read(chars)) != -1) {
            System.out.println (new String(chars, 0, len));
        }
        fileReader.close();
    }
}
