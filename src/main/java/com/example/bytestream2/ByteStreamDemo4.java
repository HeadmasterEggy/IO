package com.example.bytestream2;

import java.io.FileInputStream;
import java.io.IOException;

public class ByteStreamDemo4 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("test.txt");
        byte[] bytes = new byte[5];
        int len = fileInputStream.read(bytes);
        String str = new String(bytes, 0 , len);
        System.out.println(str);
        fileInputStream.close();
    }
}
