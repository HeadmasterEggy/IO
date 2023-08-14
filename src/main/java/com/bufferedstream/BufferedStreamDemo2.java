package com.bufferedstream;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BufferedStreamDemo2 {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(Paths.get("test.txt")));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(Files.newOutputStream(Paths.get("copy2.txt")));
        byte[] bytes = new byte[1024];
        int len;
        while((len = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, len);
        }
        bufferedOutputStream.close();
        bufferedInputStream.close();
    }
}
