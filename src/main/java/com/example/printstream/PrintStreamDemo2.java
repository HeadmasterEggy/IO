package com.example.printstream;

import java.io.PrintStream;

public class PrintStreamDemo2 {
    public static void main(String[] args) {
        //获取打印流的对象，此打印流在虚拟机启动的时候，由虚拟机创建，默认指向控制台
        // 特殊的打印流，系统中的标准输出流,是不能关闭，在系统中是唯一的。
        PrintStream ps = System.out;
        ps.println(123);
        ps.close();
        ps.println(456);
        System.out.println(789);
    }
}
