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

### 循环读取字节数据

```
FileInputStream fileInputStream = new FileInputStream("test.txt");
while ((b = fileInputStream.read()) != -1) {
    System.out.print((char) b);
}
fileInputStream.close();
```

 

### 文件复制

```java
FileInputStream fileInputStream = new FileInputStream("/Users/joey/Downloads/spiderman4.jpg");
FileOutputStream fileOutputStream = new FileOutputStream("copy.jpg");
int b;
while ((b = fileInputStream.read()) != -1) {
    fileOutputStream.write(b);
}
//先开后关，后开先关
fileOutputStream.close();
fileInputStream.close();
//6861ms
```

#### 优化时间

```java
long start = System.currentTimeMillis();

FileInputStream fileInputStream = new FileInputStream("/Users/joey/Downloads/spiderman4.jpg");
FileOutputStream fileOutputStream = new FileOutputStream("copy.jpg");
int len;
byte[] bytes = new byte[1024 * 1024 * 5];
while((len = fileInputStream.read(bytes)) != -1) {
    fileOutputStream.write(bytes, 0, len);
}
fileOutputStream.close();
fileInputStream.close();

long end = System.currentTimeMillis();
System.out.println(end - start);
//8ms
```

## 字符流

### 字符输入流【Reader】

- `public void close()` ：关闭此流并释放与此流相关联的任何系统资源。    
- `public int read()`： 从输入流读取一个字符。 
- `public int read(char[] cbuf)`： 从输入流中读取一些字符，并将它们存储到字符数组 cbuf中 。

### FileReader

- `FileReader(File file)`： 创建一个新的 FileReader ，给定要读取的File对象。   
- `FileReader(String fileName)`： 创建一个新的 FileReader ，给定要读取的文件的名称。  

`read()`方法，每次可以读取一个字符的数据，提升为int类型，读取到文件末尾，返回`-1`。

```java
FileReader fileReader = new FileReader(new File("test.txt"));
int ch;
while ((ch = fileReader.read()) != -1) {
    System.out.print((char) ch);
}
fileReader.close();
```

`read(char[] cbuf)`，每次读取b的长度个字符到数组中，返回读取到的有效字符个数，读取到末尾时，返回`-1` 。

```java
FileReader fileReader = new FileReader("test.txt");
char[] chars = new char[2];
int len;
while((len = fileReader.read(chars)) != -1) {
    System.out.println (new String(chars, 0, len));
}
fileReader.close();
```

### 字符输出流【Writer】

- `void write(int c)` 写入单个字符。
- `void write(char[] cbuf) `写入字符数组。 
- `abstract  void write(char[] cbuf, int off, int len) `写入字符数组的某一部分,off数组的开始索引,len写的字符个数。 
- `void write(String str) `写入字符串。 
- `void write(String str, int off, int len)` 写入字符串的某一部分,off字符串的开始索引,len写的字符个数。
- `void flush() `刷新该流的缓冲。  

### FileWriter

- `FileWriter(File file)`： 创建一个新的 FileWriter，给定要读取的File对象。   
- `FileWriter(String fileName)`： 创建一个新的 FileWriter，给定要读取的文件的名称。  

`write(int b)` 方法，每次可以写出一个字符数据

```java
FileWriter fileWriter = new FileWriter("test.txt", true);
//根据字符集的编码方式进行编码，再把数据写入文件
fileWriter.write(123);
fileWriter.close();
```

`write(char[] cbuf)` 和 `write(char[] cbuf, int off, int len)` ，每次可以写出字符数组中的数据

```java
FileWriter fileWriter = new FileWriter("test.txt", true);
char[] chars = {'a', 'b', 'c', 'd', 'e'};
fileWriter.write(chars);
fileWriter.write(chars, 2, 2);
fileWriter.close();
```



### 关闭和刷新

因为内置缓冲区的原因，如果不关闭输出流，无法写出字符到文件中。但是关闭的流对象，是无法继续写出数据的。如果我们既想写出数据，又想继续使用流，就需要`flush` 方法了。

* `flush` ：刷新缓冲区，流对象可以继续使用。
* `close `:先刷新缓冲区，然后通知系统释放资源。流对象不可以再被使用了。

```java
// 使用文件名称创建流对象
FileWriter fw = new FileWriter("fw.txt");
// 写出数据，通过flush
fw.write('刷'); // 写出第1个字符
fw.flush();
fw.write('新'); // 继续写出第2个字符，写出成功
fw.flush();  	
// 写出数据，通过close
fw.write('关'); // 写出第1个字符
fw.close();
fw.write('闭'); // 继续写出第2个字符,【报错】java.io.IOException: Stream closed
fw.close();
```

# 缓冲流

缓冲流,也叫高效流，是对4个基本的`FileXxx` 流的增强，所以也是4个流，按照数据类型分类：

* **字节缓冲流**：`BufferedInputStream`，`BufferedOutputStream` 
* **字符缓冲流**：`BufferedReader`，`BufferedWriter`

缓冲流的基本原理，是在创建流对象时，会创建一个内置的默认大小的缓冲区数组，通过缓冲区读写，减少系统IO次数，从而提高读写的效率。

## 字节缓冲流

* `public BufferedInputStream(InputStream in)` ：创建一个 新的缓冲输入流。 
* `public BufferedOutputStream(OutputStream out)`： 创建一个新的缓冲输出流。

### 读写字节

```java
BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(Paths.get("test.txt")));
BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(Files.newOutputStream(Paths.get("copy.txt")));
int b;
while((b = bufferedInputStream.read()) != -1) {
    bufferedOutputStream.write(b);
}
bufferedOutputStream.close();
bufferedInputStream.close();
```

### 读写数组

```java
BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(Paths.get("test.txt")));
BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(Files.newOutputStream(Paths.get("copy2.txt")));
byte[] bytes = new byte[1024];
int len;
while((len = bufferedInputStream.read(bytes)) != -1) {
    bufferedOutputStream.write(bytes, 0, len);
}
bufferedOutputStream.close();
bufferedInputStream.close();
```

## 字符缓冲流

* `public BufferedReader(Reader in)` ：创建一个 新的缓冲输入流。 
* `public BufferedWriter(Writer out)`： 创建一个新的缓冲输出流。

```java
BufferedReader bufferedReader = new BufferedReader(new FileReader("test.txt"));
String line;
while((line = bufferedReader.readLine()) != null){
    System.out.println(line);
}
bufferedReader.close();
```

`newLine()`方法

```java
BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt", true));
// 写出数据
 bufferedWriter.write("hihihi");
// 写出换行
 bufferedWriter.newLine();
 bufferedWriter.write("wowowow");
 bufferedWriter.newLine();
 bufferedWriter.close();
```
