package com.example.bufferedstream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedStreamDemo3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("test.txt"));
        String line;
        while((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }
        bufferedReader.close();
    }
}
