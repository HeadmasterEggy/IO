package com.example.bytestream1;

import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo2 {
    public static void main(String[] args) throws IOException {
        /*
          void write(int b)
          void write(byte[] b)
          void write(byte[] b, int off, int len)
         */
        FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
        byte[] bytes = {97, 98, 99, 100, 101, 102};

        //写入一个字节数组
        fileOutputStream.write(bytes);

        //写入下标[1, 3]的字节
        fileOutputStream.write(bytes, 1, 3);
        fileOutputStream.close();
    }
}
