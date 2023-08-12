package com.example.bytestream2;

import java.io.FileInputStream;
import java.io.IOException;

public class ByteStreamDemo1 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("test.txt");
        //读取数据
        int b1 = fileInputStream.read();
        System.out.println(b1);

        b1 = fileInputStream.read();
        System.out.println(b1);

        b1 = fileInputStream.read();
        System.out.println(b1);

        b1 = fileInputStream.read();
        System.out.println(b1);

        b1 = fileInputStream.read();
        System.out.println(b1);
        // 读取到末尾,返回-1
        fileInputStream.close();
    }
}
