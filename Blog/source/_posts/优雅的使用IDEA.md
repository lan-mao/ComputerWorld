---
title: 优雅的使用IDEA
date: 2020-02-10 22:58:37
tags:
categories:
---

IDEA作为Java界最好用的IDE，有大量的选项和插件供我们调教出自己喜欢的样式

## 调节配置参数

需要注意的是，配置这两个文件要在IDEA的Help菜单中打开，或者在开始界面打开  

![20200307105500_7dda15f5c58aadd99071aa7d2e411cd4.png](https://blog-source-1258302212.cos.ap-beijing.myqcloud.com/20200307105500_7dda15f5c58aadd99071aa7d2e411cd4.png)

![20200307105624_43b0bb26d8c8e9fbcdffc6983b31211e.png](https://blog-source-1258302212.cos.ap-beijing.myqcloud.com/20200307105624_43b0bb26d8c8e9fbcdffc6983b31211e.png)
### 调节JVM虚拟机的运行参数

- -Xms128m，分配堆内存时初始内存。16G内存的机器可尝试设置为 -Xms512m
- -Xmx750m，最大可使用的堆内存。16G内存的机器可尝试设置为 -Xmx2048m
- -XX:ReservedCodeCacheSize=225m，16G内存的机器可尝试设置为-XX:ReservedCodeCacheSize=500m

### 调节IDEA的个性化配置

- idea.cycle.buffer.size=1024，该属性主要用于控制控制台输出缓存。有遇到一些项目开启很多输出，控制台很快就被刷满了没办法再自动输出后面内容，这种项目建议增大该值或是直接禁用掉，禁用语句 idea.cycle.buffer.size=disabled。
- idea.max.intellisense.filesize=2500，该属性主要用于提高在编辑大文件时候的代码帮助。IntelliJ IDEA 在编辑大文件的时候还是很容易卡顿的。该属性用于设置类文件的最大大小，如果超过这个大小可能导致类文件无法加载。可以调大一些：idea.max.intellisense.filesize=5000
- idea.system.path=${user.home}/.IntelliJIdea/system，该属性主要用于指向 IntelliJ IDEA 的系统文件目录，默认是被注释，打开注释之后才算启用该属性，这里需要特别注意的是斜杠方向，这里用的是正斜杠。如果你的项目很多，则该目录会很大，如果你的 C 盘空间不够的时候，还是建议把该目录转移到其他盘符下。
- idea.config.path=${user.home}/.IntelliJIdea/config，该属性主要用于指向 IntelliJ IDEA 的个性化配置目录，默认是被注释，打开注释之后才算启用该属性，这里需要特别注意的是斜杠方向，这里用的是正斜杠。其实这里可以把路径设置到OneDrive网盘的位置，这样就可以自动地备份、同步了。

## 设置IDEA的选项

需要注意，IDEA中的有一些设置在打开项目之后的设置默认是不影响到另一个项目的，如果想要调节全局设置，可以设置在开始界面的Configure菜单的Setting选项

### 让IDEA更好看

#### 设置鼠标悬浮提示

即当鼠标移动到类或者方法上时，可以提示类或方法信息。

![20200307110545_2f784c38cec6cc19d21909ea94a6e7e5.png](https://blog-source-1258302212.cos.ap-beijing.myqcloud.com/20200307110545_2f784c38cec6cc19d21909ea94a6e7e5.png)

#### 开启行号和方法线
![20200307111027_3579644aa23d08eea3629396afce7205.png](https://blog-source-1258302212.cos.ap-beijing.myqcloud.com/20200307111027_3579644aa23d08eea3629396afce7205.png)

#### 滑动到最后还可以继续滑

![20200307111107_60f8a435236b6c6410e8774964193996.png](https://blog-source-1258302212.cos.ap-beijing.myqcloud.com/20200307111107_60f8a435236b6c6410e8774964193996.png)

### 设置代码换行

1. 根据屏幕宽度换行。这是软换行，并不是真的换行
    ![20200307111310_daa103a9ea626cbfa1ab47600914c188.png](https://blog-source-1258302212.cos.ap-beijing.myqcloud.com/20200307111310_daa103a9ea626cbfa1ab47600914c188.png)
2. 根据代码长度换行。是真的换行
   ![20200307111422_b13ea302b8b828ecf8aa0a53e6c20f62.png](https://blog-source-1258302212.cos.ap-beijing.myqcloud.com/20200307111422_b13ea302b8b828ecf8aa0a53e6c20f62.png)

### 取消保存自动删除行尾空格

IDEA在默认情况下会自动删除行尾的空格，这样可能造成在git上即使我们没有修改代码，但还是提示有修改。

![20200307111701_342873369383e5541921695a4f6c5154.png](https://blog-source-1258302212.cos.ap-beijing.myqcloud.com/20200307111701_342873369383e5541921695a4f6c5154.png)

### 自动导入包

![20200307111822_fb855f18f38147656c13893460b29058.png](https://blog-source-1258302212.cos.ap-beijing.myqcloud.com/20200307111822_fb855f18f38147656c13893460b29058.png)  

这里的选项1代表在书写代码时自动优化导入的包，比如去掉一些没用的包。选项2代表在书写代码时自动导入包。但对于同名的包，还需要`Alt+Enter`手动导入。

### 代码提示

Idea的代码提示默认区分大小写，默认为`First Letter Only`。我们可以取消`Match case`选项，这样就不区分大小写了。

![20200307111953_91280125911225f4708be29e98e08160.png](https://blog-source-1258302212.cos.ap-beijing.myqcloud.com/20200307111953_91280125911225f4708be29e98e08160.png)

在一些需要写SQL语句的地方，比如MyBatis的映射文件，我们也希望它可以像写代码一样提供表信息等的提示。这可以更改下面的两个地方实现

![20200307112147_b6d2708fc8dc0d3f7b0c20ce6721adb2.png](https://blog-source-1258302212.cos.ap-beijing.myqcloud.com/20200307112147_b6d2708fc8dc0d3f7b0c20ce6721adb2.png)

![20200307112155_e9a972bc436aa491f329c1f1113c13fa.png](https://blog-source-1258302212.cos.ap-beijing.myqcloud.com/20200307112155_e9a972bc436aa491f329c1f1113c13fa.png)

## IDEA的编码问题

### IDEA的默认编码和项目编码

在`Editor -> File Encodings` 选项卡中

- IDE 的编码默认是 UTF-8，Project Encoding 默认是 GBK，修改为 UTF-8。
- properties设置了专门的编码，建议设为UTF-8，并且勾选Transparent native-to-ascii conversion 选项，该选项主要用于转化ASCII字符，一般都要勾选，不然 Properties 文件中的注释显示的都不会是中文。

![20200307112817_f321b52d0f616715dd63b4475489b84c.png](https://blog-source-1258302212.cos.ap-beijing.myqcloud.com/20200307112817_f321b52d0f616715dd63b4475489b84c.png)

### 设置文件的字体

字体中必须包含中文，否则依然可能造成乱码、字符显示不出等问题

![20200307112935_5416d21d86f606349c46a6d92eb99836.png](https://blog-source-1258302212.cos.ap-beijing.myqcloud.com/20200307112935_5416d21d86f606349c46a6d92eb99836.png)

如图选项`Show only monospaced fonts`为只显示等宽字体，个人喜欢使用`Microsoft Yahei Mono`字体，包含中英文，样式和`Consola`字体类似。

### 设置控制台的字体

如果控制台字体出现乱码则需要修改该选项：

![20200307113039_fe56bb7bbba5a143eb6fb9efd6811bc3.png](https://blog-source-1258302212.cos.ap-beijing.myqcloud.com/20200307113039_fe56bb7bbba5a143eb6fb9efd6811bc3.png)

### Tomcat乱码

如果你的 Tomcat 控制台输出乱码，并且你已经保证了本文上面的控制台字体设置的字体包含中文，那你还可以尝试下在 Tomcat 的 VM 参数上加上：`-Dfile.encoding=UTF-8`

## 使用待办事项

我们可以使用TODO语句创建一个代办事项。待办事项的在下方的TODO窗口中可以看到。

![20200307113236_e3d5eb1883730bef65b54271618bb39d.png](https://blog-source-1258302212.cos.ap-beijing.myqcloud.com/20200307113236_e3d5eb1883730bef65b54271618bb39d.png)

如图所示，可以创建单行注释，也可以创建多行注释。使用多行注释的时候需要注意，第二行必须有缩进，不然就会只是当做普通注释

## 快捷键设置

1. 在Windows系统中，因为`Ctrl+Space`被系统的输入法占用掉了，所以可以更改为`Ctrl+,`

    ![20200307113648_9d6cb1c580e51c2f3c1fd9f9de950481.png](https://blog-source-1258302212.cos.ap-beijing.myqcloud.com/20200307113648_9d6cb1c580e51c2f3c1fd9f9de950481.png)
2. 启用`Ctrl+鼠标滚轮`调节字体大小
   ![20200307113956_cb98bde763ec7ce8eafc7627e16e11da.png](https://blog-source-1258302212.cos.ap-beijing.myqcloud.com/20200307113956_cb98bde763ec7ce8eafc7627e16e11da.png)


## 插件推荐

1. String Manipulation  
   这个插件可以对字符串进行一些大小写转换等操作，默认的快捷键是`Alt+M`
   ![20200307114359_6c474f3f0f6e2c207e166b36e055f4ff.png](https://blog-source-1258302212.cos.ap-beijing.myqcloud.com/20200307114359_6c474f3f0f6e2c207e166b36e055f4ff.png)
2. Rainbow Brackets  
   将括号变成彩色，分辨一大堆括号可以更有层次感
3. Gitee  
   类似于IDEA中默认有的Github插件，Gitee插件提供了对码云仓库的一些访问

## 参考资料

- [Introduction · IntelliJ-IDEA-Tutorial](https://youmeek.gitbooks.io/intellij-idea-tutorial/content/)
- [IntelliJ Idea 常用快捷键列表 - 一路前行 - 博客园](https://www.cnblogs.com/zhangpengshou/p/5366413.html)