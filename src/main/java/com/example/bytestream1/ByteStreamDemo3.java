package com.example.bytestream1;

import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo3 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
        String str = "Hello World!";
        byte[] bytes = str.getBytes();
        fileOutputStream.write(bytes);

        //换行
        fileOutputStream.write("\n".getBytes());

        String str2 = "Hello World Again!";
        byte[] bytes2 = str2.getBytes();
        fileOutputStream.write(bytes2);
        fileOutputStream.close();
    }
}
