package com.bufferedstream;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BufferedStreamDemo1 {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(Paths.get("test.txt")));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(Files.newOutputStream(Paths.get("copy.txt")));
        int b;
        while((b = bufferedInputStream.read()) != -1) {
            bufferedOutputStream.write(b);
        }
        bufferedOutputStream.close();
        bufferedInputStream.close();
    }
}
