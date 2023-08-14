package com.bufferedstream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedStreamDemo4 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt", true));
      	// 写出数据
        bufferedWriter.write("hihihi");
      	// 写出换行
        bufferedWriter.newLine();
        bufferedWriter.write("wowowow");
        bufferedWriter.newLine();
        bufferedWriter.close();
    }
}
