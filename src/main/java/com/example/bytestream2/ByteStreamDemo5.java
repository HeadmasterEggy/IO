package com.example.bytestream2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo5 {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        FileInputStream fileInputStream = new FileInputStream("/Users/joey/Downloads/spiderman4.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("copy.jpg");
        int len;
        byte[] bytes = new byte[1024 * 1024 * 5];
        while((len = fileInputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, len);
        }
        fileOutputStream.close();
        fileInputStream.close();

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
