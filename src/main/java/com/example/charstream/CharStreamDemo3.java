package com.example.charstream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamDemo3 {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("test.txt", true);
        //根据字符集的编码方式进行编码，再把数据写入文件
        fileWriter.write(123);

        char[] chars = {'a', 'b', 'c', 'd', 'e'};
        fileWriter.write(chars);
        fileWriter.write(chars, 2, 2);
        fileWriter.close();
    }
}
