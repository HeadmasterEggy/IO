package com.example.bytestream2;

import java.io.FileInputStream;
import java.io.IOException;

public class ByteStreamDemo2 {
    public static void main(String[] args) throws IOException {
        //字节输入流循环读取
        FileInputStream fileInputStream = new FileInputStream("test.txt");
        int b;
        while ((b = fileInputStream.read()) != -1) {
            System.out.print((char) b);
        }
        fileInputStream.close();
    }
}
