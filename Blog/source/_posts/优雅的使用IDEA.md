---
title: 优雅的使用IDEA

date: 2020-02-10 22:58:37

tags:
   - IDEA
   - 工具

categories:
   - 1/0世界
   - JAVA

---

IDEA作为Java界最好用的IDE（不接受反驳，不听不听不听），有大量的选项和插件供我们调教出自己喜欢的样式

## 调节配置参数
配置参数调节主要用到两个文件：`idea.properties`和`idea64.exe.vmoptions`。`idea.properties`文件配置的是IDEA的自身的相关配置，例如IDEA的插件目录、系统文件目录、配置文件目录等等；`idea64.exe.vmoptions`是IDEA运行的JVM环境配置，例如运行内存等  
可以直接在IDEA的安装目录的`bin`文件夹下直接打开这两个文件，但是建议在IDEA的Help菜单中或者在开始界面打开进行配置  

![在开始界面中打开参数文件](http://blog-1258302212.cos.ap-nanjing.myqcloud.com/pasteimageintomarkdown/2021-01-08/9049491214300.png)

![在Help文件夹中打开参数文件](http://blog-1258302212.cos.ap-nanjing.myqcloud.com/pasteimageintomarkdown/2021-01-08/9737470318100.png)


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

![设置显示鼠标悬浮提示](http://blog-1258302212.cos.ap-nanjing.myqcloud.com/pasteimageintomarkdown/2021-01-08/9257505521700.png)

#### 开启行号和方法线

![开启行号和方法线](http://blog-1258302212.cos.ap-nanjing.myqcloud.com/pasteimageintomarkdown/2021-01-08/9335581014300.png)

#### 滑动到最后还可以继续滑

![设置虚拟空行](http://blog-1258302212.cos.ap-nanjing.myqcloud.com/pasteimageintomarkdown/2021-01-08/9395317483600.png)

### 设置代码换行

1. 根据屏幕宽度换行。这是软换行，并不是真的换行  
   ![软换行](http://blog-1258302212.cos.ap-nanjing.myqcloud.com/pasteimageintomarkdown/2021-01-08/9456831599800.png)
   
2. 根据代码长度换行。是真的换行  
   ![硬换行](http://blog-1258302212.cos.ap-nanjing.myqcloud.com/pasteimageintomarkdown/2021-01-08/9502855121300.png)

### 自动导入包

![导包设置](http://blog-1258302212.cos.ap-nanjing.myqcloud.com/pasteimageintomarkdown/2021-01-08/9654966123400.png)

这里的选项1是在书写代码时自动优化导入的包，比如去掉一些没用到的包。选项2是在书写代码时自动导入包。但对于同名的包，还需要`Alt+Enter`手动导入。

### 代码提示

Idea的代码提示默认区分大小写，默认为`First Letter Only`。我们可以取消`Match case`选项，这样就不区分大小写了。

![代码提示大小写配置](http://blog-1258302212.cos.ap-nanjing.myqcloud.com/pasteimageintomarkdown/2021-01-08/10180372733100.png)

在一些需要写SQL语句的地方，比如MyBatis的映射文件，我们也希望它可以像写代码一样提供表信息等的提示。这可以更改下面的两个地方实现

![SQL语句的代码提示](http://blog-1258302212.cos.ap-nanjing.myqcloud.com/pasteimageintomarkdown/2021-01-08/10283116999800.png)

![项目与数据库的关联](http://blog-1258302212.cos.ap-nanjing.myqcloud.com/pasteimageintomarkdown/2021-01-08/10356699883400.png)

## IDEA的编码问题

### IDEA的默认编码和项目编码

在`Editor -> File Encodings` 选项卡中

- IDE 的编码默认是 UTF-8，Project Encoding 默认是 GBK，修改为 UTF-8。
- properties设置了专门的编码，建议设为UTF-8，并且勾选Transparent native-to-ascii conversion 选项，该选项主要用于转化ASCII字符，一般都要勾选，不然 Properties 文件中的注释显示的都不会是中文。

![编码设置](http://blog-1258302212.cos.ap-nanjing.myqcloud.com/pasteimageintomarkdown/2021-01-08/10679692070100.png)

### Tomcat乱码

如果你的 Tomcat 控制台输出乱码，可以尝试下在 Tomcat 的 VM 参数上加上：`-Dfile.encoding=UTF-8`

## 快捷键设置

1. 在Windows系统中，因为`Ctrl+Space`被系统的输入法占用掉了，所以可以更改为`Ctrl+,`  
   ![更改`Ctrl + Space`快捷键](http://blog-1258302212.cos.ap-nanjing.myqcloud.com/pasteimageintomarkdown/2021-01-08/8306941753400.png)
   
2. 启用`Ctrl+鼠标滚轮`调节字体大小  
   ![设置鼠标滚轮](http://blog-1258302212.cos.ap-nanjing.myqcloud.com/pasteimageintomarkdown/2021-01-08/10954513501000.png)

## 插件推荐

1. String Manipulation  
   这个插件可以对字符串进行一些大小写转换等操作，默认的快捷键是`Alt+M`    
   ![String Manipulation 操作菜单](http://blog-1258302212.cos.ap-nanjing.myqcloud.com/pasteimageintomarkdown/2021-01-08/7970751971400.png)
   
2. Rainbow Brackets  
   将括号变成彩色，分辨一大堆括号可以更有层次感
   
3. Gitee  
   类似于IDEA中默认有的Github插件，Gitee插件提供了对码云仓库的一些访问
   
4. PasteImageIntoMarkdown  
   提供在Markdown文件中粘贴图片，并可选择图片的存放地址，如：本地、阿里云、腾讯云、七牛云
   
5. Solarized Themes  
   是我比较喜欢的背景色为黄色的护眼主题，是全局的主题
   
6. Chinese (Simplified) Language Pack / 中文语言包   
   JetBrains官方提供的IDEA中文包，绝大部分内容都有中文翻译。虽然我个人还是建议使用英文版，不过英语不太好的同学可以用一下。

## 参考资料

- [Introduction · IntelliJ-IDEA-Tutorial](https://youmeek.gitbooks.io/intellij-idea-tutorial/content/)
- [IntelliJ Idea 常用快捷键列表 - 一路前行 - 博客园](https://www.cnblogs.com/zhangpengshou/p/5366413.html)