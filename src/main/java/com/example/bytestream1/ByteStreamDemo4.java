package com.example.bytestream1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo4 {
    public static void main(String[] args) throws IOException {
        //续写
        FileOutputStream fileOutputStream = new FileOutputStream("test.txt", true);
        fileOutputStream.write("test".getBytes());
        fileOutputStream.close();
    }
}
