package com.example.convertstream;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ConvertStreamDemo2 {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("test.txt", StandardCharsets.UTF_8, true);
        fileWriter.write("Hello");
        fileWriter.close();
    }
}
