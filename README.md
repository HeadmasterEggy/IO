# IO流

## 字节流

### 文件字节流

* `public FileOutputStream(File file)`：创建文件输出流以写入由指定的 File对象表示的文件。 
* `public FileOutputStream(String name)`： 创建文件输出流以指定的名称写入文件。  

```java
FileOutputStream fileOutputStream = new FileOutputStream("README.md");
//Integer会转换成ASCII码
fileOutputStream.write(123);
fileOutputStream.close();
```

### FileOutputStream源码

```java
public FileOutputStream(String name) throws FileNotFoundException {
  //在写入文件时，如果文件不存在，则新建文件并写入，如果存在会override再写入
  this(name != null ? new File(name) : null, false);
}
```

### 字节输出流

* `public void close()` ：关闭此输出流并释放与此流相关联的任何系统资源。  
* `public void flush() ` ：刷新此输出流并强制任何缓冲的输出字节被写出。  
* `public void write(byte[] b)`：将 b.length字节从指定的字节数组写入此输出流。  
* `public void write(byte[] b, int off, int len)` ：从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流。  
* `public abstract void write(int b)` ：将指定的字节输出流。

```java
FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
byte[] bytes = {97, 98, 99, 100, 101, 102};

//写入一个字节数组
fileOutputStream.write(bytes);

//写入从下标1开始后的3个字节
fileOutputStream.write(bytes, 1, 3);
fileOutputStream.close();
```

### 数据追加续写

- `public FileOutputStream(File file, boolean append)`： 创建文件输出流以写入由指定的 File对象表示的文件。  
- `public FileOutputStream(String name, boolean append)`： 创建文件输出流以指定的名称写入文件。  

`true` 表示追加数据，`false` 表示清空原有数据

### 字节输入流

- `public void close()` ：关闭此输入流并释放与此流相关联的任何系统资源。    
- `public abstract int read()`： 从输入流读取数据的下一个字节。 
- `public int read(byte[] b)`： 从输入流中读取一些字节数，并将它们存储到字节数组 b中 。

### FileInputStream

* `FileInputStream(File file)`： 通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系统中的 File对象 file命名。 
* `FileInputStream(String name)`： 通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系统中的路径名 name命名。  

### 读取字节数据

`read()`方法: 读取一个字节, 读到文件末尾返回-1

```java
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
```

### 虚幻读取字节数据

```
FileInputStream fileInputStream = new FileInputStream("test.txt");
while ((b = fileInputStream.read()) != -1) {
    System.out.print((char) b);
}
fileInputStream.close();
```

 
