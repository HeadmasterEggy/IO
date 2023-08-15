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

## 练习:文本排序

请将文本信息恢复顺序。

```
3.侍中、侍郎郭攸之、费祎、董允等，此皆良实，志虑忠纯，是以先帝简拔以遗陛下。愚以为宫中之事，事无大小，悉以咨之，然后施行，必得裨补阙漏，有所广益。
8.愿陛下托臣以讨贼兴复之效，不效，则治臣之罪，以告先帝之灵。若无兴德之言，则责攸之、祎、允等之慢，以彰其咎；陛下亦宜自谋，以咨诹善道，察纳雅言，深追先帝遗诏，臣不胜受恩感激。
4.将军向宠，性行淑均，晓畅军事，试用之于昔日，先帝称之曰能，是以众议举宠为督。愚以为营中之事，悉以咨之，必能使行阵和睦，优劣得所。
2.宫中府中，俱为一体，陟罚臧否，不宜异同。若有作奸犯科及为忠善者，宜付有司论其刑赏，以昭陛下平明之理，不宜偏私，使内外异法也。
1.先帝创业未半而中道崩殂，今天下三分，益州疲弊，此诚危急存亡之秋也。然侍卫之臣不懈于内，忠志之士忘身于外者，盖追先帝之殊遇，欲报之于陛下也。诚宜开张圣听，以光先帝遗德，恢弘志士之气，不宜妄自菲薄，引喻失义，以塞忠谏之路也。
9.今当远离，临表涕零，不知所言。
6.臣本布衣，躬耕于南阳，苟全性命于乱世，不求闻达于诸侯。先帝不以臣卑鄙，猥自枉屈，三顾臣于草庐之中，咨臣以当世之事，由是感激，遂许先帝以驱驰。后值倾覆，受任于败军之际，奉命于危难之间，尔来二十有一年矣。
7.先帝知臣谨慎，故临崩寄臣以大事也。受命以来，夙夜忧叹，恐付托不效，以伤先帝之明，故五月渡泸，深入不毛。今南方已定，兵甲已足，当奖率三军，北定中原，庶竭驽钝，攘除奸凶，兴复汉室，还于旧都。此臣所以报先帝而忠陛下之职分也。至于斟酌损益，进尽忠言，则攸之、祎、允之任也。
5.亲贤臣，远小人，此先汉所以兴隆也；亲小人，远贤臣，此后汉所以倾颓也。先帝在时，每与臣论此事，未尝不叹息痛恨于桓、灵也。侍中、尚书、长史、参军，此悉贞良死节之臣，愿陛下亲之信之，则汉室之隆，可计日而待也。
```

### 案例分析

1. 逐行读取文本信息。
2. 把读取到的文本存储到集合中
3. 对集合中的文本进行排序
4. 遍历集合，按顺序，写出文本信息。

### 案例实现

```java
public class Demo05Test {
    public static void main(String[] args) throws IOException {
        //1.创建ArrayList集合,泛型使用String
        ArrayList<String> list = new ArrayList<>();
        //2.创建BufferedReader对象,构造方法中传递FileReader对象
        BufferedReader br = new BufferedReader(new FileReader("10_IO\\in.txt"));
        //3.创建BufferedWriter对象,构造方法中传递FileWriter对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("10_IO\\out.txt"));
        //4.使用BufferedReader对象中的方法readLine,以行的方式读取文本
        String line;
        while((line = br.readLine())!=null){
            //5.把读取到的文本存储到ArrayList集合中
            list.add(line);
        }
        //6.使用Collections集合工具类中的方法sort,对集合中的元素按照自定义规则排序
        Collections.sort(list, new Comparator<String>() {
            /*
                o1-o2:升序
                o2-o1:降序
             */
            @Override
            public int compare(String o1, String o2) {
                //依次比较集合中两个元素的首字母,升序排序
                return o1.charAt(0)-o2.charAt(0);
            }
        });
        //7.遍历ArrayList集合,获取每一个元素
        for (String s : list) {
            //8.使用BufferedWriter对象中的方法wirte,把遍历得到的元素写入到文本中(内存缓冲区中)
            bw.write(s);
            //9.写换行
            bw.newLine();
        }
        //10.释放资源
        bw.close();
        br.close();
    }
}
```

# 转换流

## 字符集

* **字符集 `Charset`**：也叫编码表。是一个系统支持的所有字符的集合，包括各国家文字、标点符号、图形符号、数字等。

计算机要准确的存储和识别各种字符集符号，需要进行字符编码，一套字符集必然至少有一套字符编码。常见字符集有ASCII字符集、GBK字符集、Unicode字符集等。![](/Users/joey/Downloads/资料/day29-IO（其他流）/笔记/img/1_charset.jpg)

可见，当指定了**编码**，它所对应的**字符集**自然就指定了，所以**编码**才是我们最终要关心的。

* **ASCII字符集** ：
  * ASCII（American Standard Code for Information Interchange，美国信息交换标准代码）是基于拉丁字母的一套电脑编码系统，用于显示现代英语，主要包括控制字符（回车键、退格、换行键等）和可显示字符（英文大小写字符、阿拉伯数字和西文符号）。
  * 基本的ASCII字符集，使用7位（bits）表示一个字符，共128字符。ASCII的扩展字符集使用8位（bits）表示一个字符，共256字符，方便支持欧洲常用字符。
* **ISO-8859-1字符集**：
  * 拉丁码表，别名Latin-1，用于显示欧洲使用的语言，包括荷兰、丹麦、德语、意大利语、西班牙语等。
  * ISO-8859-1使用单字节编码，兼容ASCII编码。
* **GBxxx字符集**：
  * GB就是国标的意思，是为了显示中文而设计的一套字符集。
  * **GB2312**：简体中文码表。一个小于127的字符的意义与原来相同。但两个大于127的字符连在一起时，就表示一个汉字，这样大约可以组合了包含7000多个简体汉字，此外数学符号、罗马希腊的字母、日文的假名们都编进去了，连在ASCII里本来就有的数字、标点、字母都统统重新编了两个字节长的编码，这就是常说的"全角"字符，而原来在127号以下的那些就叫"半角"字符了。
  * **GBK**：最常用的中文码表。是在GB2312标准基础上的扩展规范，使用了双字节编码方案，共收录了21003个汉字，完全兼容GB2312标准，同时支持繁体汉字以及日韩汉字等。
  * **GB18030**：最新的中文码表。收录汉字70244个，采用多字节编码，每个字可以由1个、2个或4个字节组成。支持中国国内少数民族的文字，同时支持繁体汉字以及日韩汉字等。
* **Unicode字符集** ：
  * Unicode编码系统为表达任意语言的任意字符而设计，是业界的一种标准，也称为统一码、标准万国码。
  * 它最多使用4个字节的数字来表达每个字母、符号，或者文字。有三种编码方案，UTF-8、UTF-16和UTF-32。最为常用的UTF-8编码。
  * UTF-8编码，可以用来表示Unicode标准中任何字符，它是电子邮件、网页及其他存储或传送文字的应用中，优先采用的编码。互联网工程工作小组（IETF）要求所有互联网协议都必须支持UTF-8编码。所以，我们开发Web应用，也要使用UTF-8编码。它使用一至四个字节为每个字符编码，编码规则：
    1. 128个US-ASCII字符，只需一个字节编码。
    2. 拉丁文等字符，需要二个字节编码。 
    3. 大部分常用字（含中文），使用三个字节编码。
    4. 其他极少使用的Unicode辅助字符，使用四字节编码。

## InputStreamReader

* `InputStreamReader(InputStream in)`: 创建一个使用默认字符集的字符流。 
* `InputStreamReader(InputStream in, String charsetName)`: 创建一个指定字符集的字符流。

### 指定编码读取

```java
FileReader reader = new FileReader("test.txt", Charset.forName("GBK"));
int ch;
while ((ch = reader.read()) != -1) {
    System.out.println((char) ch);
}
reader.close();
```

## OutputStreamWriter类

- `OutputStreamWriter(OutputStream in)`: 创建一个使用默认字符集的字符流。 
- `OutputStreamWriter(OutputStream in, String charsetName)`: 创建一个指定字符集的字符流。

```java
// 定义文件路径
String FileName = "E:\\out.txt";
// 创建流对象,默认UTF8编码
OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(FileName));
// 写出数据
osw.write("你好"); // 保存为6个字节
osw.close();
// 定义文件路径
String FileName2 = "E:\\out2.txt";
// 创建流对象,指定GBK编码
OutputStreamWriter osw2 = new OutputStreamWriter(new FileOutputStream(FileName2),"GBK");
// 写出数据
osw2.write("你好");// 保存为4个字节
osw2.close();
```

### 转换流理解图解

**转换流是字节与字符间的桥梁！**![2_zhuanhuan.jpg](img/2_zhuanhuan.jpg)

# 序列化

Java 提供了一种对象**序列化**的机制。用一个字节序列可以表示一个对象，该字节序列包含该`对象的数据`、`对象的类型`和`对象中存储的属性`等信息。字节序列写出到文件之后，相当于文件中**持久保存**了一个对象的信息。 

反之，该字节序列还可以从文件中读取回来，重构对象，对它进行**反序列化**。`对象的数据`、`对象的类型`和`对象中存储的数据`信息，都可以用来在内存中创建对象。看图理解序列化： ![](/Users/joey/Downloads/资料/day29-IO（其他流）/笔记/img/3_xuliehua.jpg)

## ObjectOutputStream

* `public ObjectOutputStream(OutputStream out) `： 创建一个指定OutputStream的ObjectOutputStream。

### 序列化操作

1. 一个对象要想序列化，必须满足两个条件:

* 该类必须实现`java.io.Serializable ` 接口，`Serializable` 是一个标记接口，不实现此接口的类将不会使任何状态序列化或反序列化，会抛出`NotSerializableException` 。
* 该类的所有属性必须是可序列化的。如果有一个属性不需要可序列化的，则该属性必须注明是瞬态的，使用`transient` 关键字修饰。

```java
public class Student implements Serializable {
    private String name;
    private int age;
}
```

- `public final void writeObject (Object obj)` : 将指定的对象写出。

```java
Student stu = new Student("张三", 23);
ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("test.txt", true));
objectOutputStream.writeObject(stu);
objectOutputStream.close();
```

## ObjectInputStream

ObjectInputStream反序列化流，将之前使用ObjectOutputStream序列化的原始数据恢复为对象。

* `public ObjectInputStream(InputStream in) `： 创建一个指定InputStream的ObjectInputStream。

```java
ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("test.txt"));
Student o = (Student) objectInputStream.readObject();
System.out.println(o);
objectInputStream.close();
```
