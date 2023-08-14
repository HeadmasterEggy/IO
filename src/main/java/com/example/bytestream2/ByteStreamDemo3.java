package com.example.bytestream2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo3 {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        FileInputStream fileInputStream = new FileInputStream("/Users/joey/Downloads/spiderman4.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("copy.jpg");
        int b;
        while ((b = fileInputStream.read()) != -1) {
            fileOutputStream.write(b);
        }
        //先开后关，后开先关
        fileOutputStream.close();
        fileInputStream.close();

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
