package com.example.printstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class PrintStreamDemo1 {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream printStream = new PrintStream(new FileOutputStream("test.txt"), true, StandardCharsets.UTF_8);
        printStream.println(97);
        printStream.print(true);
        printStream.printf("hello world");
        printStream.close();
    }
}
