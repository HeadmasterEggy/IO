package com.example.objectstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectStreamDemo1 {
    public static void main(String[] args) throws IOException {
        Student stu = new Student("张三", 23);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("test.txt", true));
        objectOutputStream.writeObject(stu);
        objectOutputStream.close();
    }
}
