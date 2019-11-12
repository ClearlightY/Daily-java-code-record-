# IO
>IO流用来处理设备之间的数据传输
>Java对数据的操作是通过流的方式
>Java用来操作流的对象都在IO包中
>流按操作数据分为两种 : 字节流与字符流
流按流向分为 : 输入流, 输出流

---

## 输入输出定义
内存 -- 硬盘(外设)

硬盘->内存 : 输入(读) -- 读取硬盘,持续输入

内存->硬盘 : 输出(写) -- 往硬盘写,疯狂输出

>将外设中的数据读取到内存中 : 输入
>将内存中的数据写入到外设中 : 输出

**字节流的由来:**
其实就是 : 字节流读取文字字节数据后,不直接操作而是先查指定的编码表,获取对应的文字.
在对这个文字进行操作. 简单说 : 字节流 + 编码表 

## IO流常用基类
- 字节流的抽象基类(顶层父类)
   - InputStream
   - OutputStream
 - 字符流的抽象基类
   - Reader
   - Writer

## 字符流的缓冲区
- 缓冲区的出现提高了对数据的读写效率
- 对应类
  - BufferedWriter
  - BufferedReader
- 缓冲区要结合流才可以使用
- 在流的基础上对流的功能进行了增强 

缓冲区的实际应用
>超市推车,车里面在放一个筐 ,存时方便,取得时候直接从车里把筐提出来效率更快.

<font color=red>缓冲区类用到的设计模式</font>
>装饰设计模式 : 对一组对象的功能进行增强! 

Tips:
Ctrl + Alt + M : 重构,将选中的代码添加到一个新的方法中

## 字节流
- 基本操作与字符流类相同
- 但它不仅可以操作字符,还可以操作其他媒体文件

Tips:
中文汉字
编码 | 中文汉字字节数 | 英文字母字节数
:---|--- |---
GB2312|2|1
GBK|2|1
GB18030|2|1
ISO-8859-1|1|1
UTF-8|3|1
UTF-16|4|4
UTF-16BE|2|2
UTF-16LE|2|2

## 读写文件的步骤
1. 首先读取文件内容
创建`XXXReader/XXXInputStream对象`,并且传入读取文件的路径,从而达到和指定文件关联
2. 创建一个缓冲区对象,将流对象添加到缓冲区
创建`BufferedXXX(Reader/InputStream)对象`,并将刚刚创建的流对象作为参数传进缓冲区中
3. 同前两步,创建一个将要读取的内容写入到指定位置中(若指定文件存在则覆盖,不存在则重新创建)
然后再把创建的流对象添加到缓冲区中
4. 开始读取内容后将读取到的内容写入到输出缓冲区中
四种复制的方法(其中fis,fos,bufis,bufos为流对象或缓冲流对象的变量名)
第一种 : 一个一个的读取 : 不要使用这种方法,效率特别低!
```
    int ch = 0;
    while ((ch = fis.read()) != -1) {
      fos.write(ch);
    }
```
第二种 : 未使用缓冲区时,创建一个数组,每次读取1K大小数据
```
    byte[] buf = new byte[1024];

    int ch = 0;
    while ((ch = fis.read(buf)) != -1) {
        fos.write(buf, 0, ch);
    }
```
第三种 : 使用缓冲区,先将数据存入到缓冲区中,之后在依次读取缓冲区中的内容
```
    int ch = 0;
    // 先将数据读到缓冲区中,后从缓冲区中向硬盘中写入数据
    while ((ch = bufis.read()) != -1) {
        bufos.write(ch);
    }
```
第四种 : 直接获取文件的大小,直接创建一个文件大小的数组,读取文件大小的内容后,在写入
```
    byte[] buf = new byte[bufis.available()];
    bufis.read(buf);
    bufos.write(buf);
```
5. 关闭资源
`XXX.close();`

## 字节流与字符流的转换
InputStreamReader : 字节流通向字符流的桥梁
OutputStreamWriter : 字符流通向字节流的桥梁

实例:通过控制台输入得到字节流对象,后通过转换为字符流,又使用缓冲流进行包装字符流将写入的数据读取到字符缓冲流中.
之后写入到输出流中将数据输出到控制台中
```java
import java.io.*;

public class TransStreamDemo {
    public static void main(String[] args) throws IOException {
        // in : “标准”输入流。此流已打开并准备提供输入数据。
        //      通常，此流对应于键盘输入或者由主机环境或用户指定的另一个输入源。
        // 因此将键盘的输入作为数据读取到输入流中
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        // “标准”输出流。此流已打开并准备接受输出数据。
        // 通常，此流对应于显示器输出或者由主机环境或用户指定的另一个输出目标
        // 因此数据写入到输出流中显示在显示器中
        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = null;

        while ((line = bufr.readLine()) != null) {
            if ("over".equals(line)) {
                return;
            }
            bufw.write(line.toUpperCase());
            bufw.newLine();
            bufw.flush();
        }

        bufr.close();
        bufw.close();
    }
}
```

