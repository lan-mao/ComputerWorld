---
title: Java中的流操作
date: 2020-02-10 22:06:24
tags:
- JAVA
- I/O
categories:
- 1/0世界
- JAVA
---
## 流的分类

要分清流，首先要明白一些概念：
- 输入/读取：程序从外界取得数据
- 输出/写入：程序向外界写入数据
- 数据源：程序读取/写入的目标

不管是读取还是写入，要明白都是相对于程序而言的，而不是对目标。  
- 按流向分：
  - 输入流：从数据源到程序。一般以InputStream、Reader结尾
  - 输出流：从程序到数据源。一般以OutputStream、Writer结尾
- 按处理单元分：
  - 字节流：以字节为单位处理数据，一般以Stream结尾
  - 字符流：以字符为单位处理数据，一般以Reader/Writer结尾
- 按处理对象分：
  - 节点流：从源头直接获取数据。如：FileInputStream，FileReader，ByteArrayInputStream
  - 处理流：不直接连接数据源，是对流的封装，是处理流的流，使得流的操作更加高效。如：BufferedWriter，BufferedReader


## 四大抽象流对象
在JavaSE中，基本所有的流操作，都是这四种抽象对象的子类。
- InputStream：字节输入流的父类，数据单位为字节
- OutputStream：字节输出流的父类，数据单位为字节
- Reader：字符输入流的父类，数据单位为字符
- Writer：字符输出流的父类，数据单位为字节

这四种类都继承实现了Closeable接口，而Closeable接口是AutoCloseable接口的子接口。因此这些类的子类从JDK7以后都可以使用try-with-resources方式实现流对象的自动关闭。

### InputStream

- int read()：从流中读取数据，一次读取一个字节，并将读取到的数据返回。如果读到了流的结尾返回-1；
- int read(byte[] b)/int read(byte[] b,int off,int len)：这两个方法都需要传入一个byte数组，他会将数据写入这个数组中，并返回写入的数据长度。

### OutputStream

- void write(int b)：向流中输出传入的数据。
- void write(byte[] b)/void write(byte[] b,int off,int len):向流中输出字节数组中的数据

### Reader

- int read()/int read(char[] cbuf)/int read(char[] cbuf,int off,int len)与InputStream的read()方法类似，所不同的是一次读取的是一个字符类型。

### Writer

- 

## 节点流
### 文件字节流
### 文件字符流
### 字节数组流
## 处理流
### 字节缓冲流
### 字符缓冲流
### 转换流
### 数据流
### 对象流
### 随机流
### 顺序输入流