package com.example.convertstream;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertStreamDemo1 {
    public static void main(String[] args) throws IOException {
        //创建对象并指定字符编码
        FileReader reader = new FileReader("test.txt", StandardCharsets.UTF_8);
        int ch;
        while ((ch = reader.read()) != -1) {
            System.out.println((char) ch);
        }
        reader.close();
    }
}
