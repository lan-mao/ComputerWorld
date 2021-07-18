---
title: Java基础面试题合集
date: 2021-07-06 16:03:13
tags:
  - 面试题
  - Java
alias: 
category: 
stars: 
from: 
url: 
---
# Java基础面试题合集

## 面向对象

1. 面向对象的特征

	-  封装
		- 隐藏内部属性
		- 提高代码的可用性和可维护性
		- 实现代码的高内聚和低耦合
		- 通过隐藏对象属性来保护对象内部状态
	- 继承
		- 提供代码的可重用性
		- 给对象提供了从基类获取字段的方法和能力
		- 可以在不修改类的情况下给现存的类添加新的特性
	- 多态
		- 父类或接口的引用变量可以指向子类或具体实现类的实例对象
		- 引用变量调用的方法的具体实现在编程时并不确定，而是在程序运行时确定
		- 提高了代码的扩展性
	-  抽象
		- 忽略无关的部分，根据功能而不是细节创建类
		- 提取显示世界中的某种事物的关键特性，为该事物构建模型
		- 对同一事物在不同需求下，需要提取的特性可能不一样
2. 面向对象与面向过程的区别

	面向对象比面向对象系统开销大，性能差；但面向对象更易维护，易扩展，易复用。

3. 重载与重写的区别
	1. 重载 overload
		1. 方法名相同但方法的签名不同，即参数类型，数量，顺序等至少有一个不同
		2. 不能重载只有返回值不同的方法
	2. 重写 override
		1. 在子类与父类之间
		2. 方法名，参数，返回值均相同
		3. 重写方法不能抛出新的异常或比被重写方法更加宽泛的异常
		4. 使用final关键字标识的方法不能被重写

4. 什么是构造方法

	构造方法是在创建一个类的实例化对象时运行的方法，没有返回值。

5. 构造方法的重载

	一个类可以拥有多个构造方法，但每个构造方法必须有唯一的参数列表。
	
## Java基础概念

1. JDK、JRE、JVM之间的关系
	1. JDK：Java开发工具包，包含JRE和编译器等工具
	2. JRE：Java运行环境，运行Java程序所必须的，包含JVM等 
	3. JVM：Java运行的虚拟机，用于在不同的机器上创建一个相同的运行环境

2. 为什么说Java是平台无关的编程语言

	Java程序运行在Java提供的虚拟机上，虚拟机屏蔽了底层硬件的不同，向Java程序提供了统一的应用接口。

3. JDK各个版本的特性

	[[Java7-15新特性]]

4.  什么是字节码

	字节码是Java语言变为机器语言运行的中间产物，Java语言经过编译生成可供虚拟机运行的字节码，然后由虚拟机解释执行。这使得Java语言不需要考虑平台的差异性，从而使Java语言具有了可移植的特点。
	
	> 关于语言类型的相关问题：[](https://www.iteye.com/blog/rednaxelafx-492667)

## Java语法
1.  Java中的基本数据类型是什么，各自占用多少字节？
	1. 整数型：byte(1), short(2), int(4), long(8)
	2. 字符型：char(2)
	3. 布尔型：boolean(1位)
	4. 浮点型：float(4), double(8)

2. 值传递与引用传递
	1. 值传递：传递的是变量代表的数据，而不是变量本身，修改数据原变量本身并不会发生改变。
	2. 引用传递：传递的是变量的地址，修改地址对应的数据，会直接改变原变量

3. 是否可以在static环境中访问非static变量？

	不可以，static关键字修饰的变量及方法属于类，无需初始化，且同一类的所有实例变量值是一样的；而非static变量属于具体的实例对象，必须进行初始化才可以使用。

4. char型变量中能不能存储一个中文汉字？

	char类型有两个字节，Java中默认采用Unicode编码，中文在Unicode编码中占2个字节，所以可以存储

5. String、StringBuffer、StringBuilder的区别
	1. String：只读字符串，一旦创建无法修改，每次对String的修改都会创建一个新的String对象。
	2. StringBuffer/StringBuilder：可变字符串，两者方法完全相同，但StringBuffer中所有方法都带有同步锁，线程安全；而StringBuilder没有，效率高，但线程不安全。

6. String s = new String("xyz")会创建几个对象

	String会首先在线程池中寻找“xyz”字符串的对象，如果找不到会新建一个，找到则直接使用。然后new关键字会创建一个新的String对象，并将其返回。所以需要1个或2个。

7. String为什么是不可变的

	String类中使用final关键字修饰了存储字符串的数组，所以String对象一旦创建就不可改变。
	
8. equals和== 的区别
	1. equals：用于对类进行判断是否等价
	2. == ：用于判断基本类型的数值是否相等，以及两个引用对象指向的对象是否是同一个

9. 为什么要重写hashCode和equals方法

	equals方法用来判断两个实例化对象的值是否相等，如果不重写equals方法，会默认判断两个对象的地址是否相同。hashCode方法通过计算得到一个哈希值，如果重写equals方法，则必须重写hashCode方法，否则会影响Map等集合的索引速度。

10. final,finally,finalize区别
	1. final：用于修饰类、方法、变量。被修饰的类不能被继承，被修饰的方法不能被重写，被修饰的变量需要在声明时给定值，且不能被修改。
	2. finally：用于在程序抛出异常时执行清除资源等操作，不论try代码块中是否抛出异常，finally代码块都会被执行。
	3. finalize：在Object类中定义的方法名，用于在垃圾收集器清除对象之前

11. 抽象类和接口有什么区别？
	- 类可以实现多个接口，但只能继承一个抽象类
	- 抽象类是对类的抽象，是一种模板设计；接口是对行为的抽象，是一种行为规范
	- 接口中所有声明的变量都是final的，抽象类可以包含非final的变量
	- 接口中的成员方法包括抽象方法，默认方法和静态方法，私有方法
	- 抽象类的成员方法可以是：private，protected，public

12. 继承和组合的区别在哪
	- 继承：指一个类或接口，继承另一个类或接口的功能，并
13. 请详细讲述一下RandomAccess接口有什么作用

18. [讲讲类的实例化顺序](onenote:#芋道源码——Java基础面试题&section-id={6E90FA55-6EAB-4D59-B970-49B197AABB8B}&page-id={B4831FC7-61C1-444D-A720-492FF93EE787}&object-id={CEC7420B-5552-485F-9B65-7DE9EB6A11D6}&69&base-path=https://d.docs.live.net/16e05d878f77e289/Documents/计算机大世界/语言/Java/面试题.one)
19. [什么是内部类](onenote:#芋道源码——Java基础面试题&section-id={6E90FA55-6EAB-4D59-B970-49B197AABB8B}&page-id={B4831FC7-61C1-444D-A720-492FF93EE787}&object-id={CEC7420B-5552-485F-9B65-7DE9EB6A11D6}&87&base-path=https://d.docs.live.net/16e05d878f77e289/Documents/计算机大世界/语言/Java/面试题.one)

1.  内部类的作用是什么
2.  Anonymous Inner Class（匿名内部类）是否可以继承其他类？是否可以实现接口？
3.  内部类可以引用它的包含类（外部类）的成员嘛？有马有什么限制？

21. 什么是JavaIO？](onenote:#芋道源码——Java基础面试题&section-id={6E90FA55-6EAB-4D59-B970-49B197AABB8B}&page-id={B4831FC7-61C1-444D-A720-492FF93EE787}&object-id={CEC7420B-5552-485F-9B65-7DE9EB6A11D6}&97&base-path=https://d.docs.live.net/16e05d878f77e289/Documents/计算机大世界/语言/Java/面试题.one)
22. 什么是Java序列化](onenote:#芋道源码——Java基础面试题&section-id={6E90FA55-6EAB-4D59-B970-49B197AABB8B}&page-id={B4831FC7-61C1-444D-A720-492FF93EE787}&object-id={CEC7420B-5552-485F-9B65-7DE9EB6A11D6}&A0&base-path=https://d.docs.live.net/16e05d878f77e289/Documents/计算机大世界/语言/Java/面试题.one)

1.  如何实现Java序列化
2.  Java序列化中，如果有些字段不想进行序列化怎么办？

24. 如何实现对象克隆？（什么是深克隆和浅克隆？）](onenote:#芋道源码——Java基础面试题&section-id={6E90FA55-6EAB-4D59-B970-49B197AABB8B}&page-id={B4831FC7-61C1-444D-A720-492FF93EE787}&object-id={CEC7420B-5552-485F-9B65-7DE9EB6A11D6}&D4&base-path=https://d.docs.live.net/16e05d878f77e289/Documents/计算机大世界/语言/Java/面试题.one)
25. error和exception有什么区别？CheckedException和RuntimeException有什么区别]

1.  异常的使用注意地方
2.  Throwable类常用方法？
3.  请列出5个运行时异常？
4.  throw与throws的区别？
5.  异常处理中finally语句的重要性
6.  异常处理后异常对象会发生什么

27. 说说反射的用途及实现]
1.  反射中，Class.forName和ClassLoader区别？
2.  UnsupportedOperationException是什么？

29. 什么是注解？]
30. 什么时候用断言(assert)?]
31.  Java对象创建的方式？

10.  字符型常量和字符串常量的区别](onenote:#JavaGuide\Java基础知识.md%20&section-id={6E90FA55-6EAB-4D59-B970-49B197AABB8B}&page-id={6C975D2A-B4D2-4B6C-98CE-6069987D62FA}&object-id={64D55DA0-8A44-0C47-01B2-D2D52196421E}&A5&base-path=https://d.docs.live.net/16e05d878f77e289/Documents/计算机大世界/语言/Java/面试题.one)
11.  [造器 Constructor 是否可被 override](onenote:#JavaGuide\Java基础知识.md%20&section-id={6E90FA55-6EAB-4D59-B970-49B197AABB8B}&page-id={6C975D2A-B4D2-4B6C-98CE-6069987D62FA}&object-id={64D55DA0-8A44-0C47-01B2-D2D52196421E}&B1&base-path=https://d.docs.live.net/16e05d878f77e289/Documents/计算机大世界/语言/Java/面试题.one)
12.  [重载和重写的区别](onenote:#JavaGuide\Java基础知识.md%20&section-id={6E90FA55-6EAB-4D59-B970-49B197AABB8B}&page-id={6C975D2A-B4D2-4B6C-98CE-6069987D62FA}&object-id={64D55DA0-8A44-0C47-01B2-D2D52196421E}&B8&base-path=https://d.docs.live.net/16e05d878f77e289/Documents/计算机大世界/语言/Java/面试题.one)
13.  [Java 面向对象编程三大特性:封装、继承、多态](onenote:#JavaGuide\Java基础知识.md%20&section-id={6E90FA55-6EAB-4D59-B970-49B197AABB8B}&page-id={6C975D2A-B4D2-4B6C-98CE-6069987D62FA}&object-id={64D55DA0-8A44-0C47-01B2-D2D52196421E}&BE&base-path=https://d.docs.live.net/16e05d878f77e289/Documents/计算机大世界/语言/Java/面试题.one)

1.  封装
2.  继承
3.  多态

17.  [在一个静态方法内调用一个非静态成员为什么是非法的](onenote:#JavaGuide\Java基础知识.md%20&section-id={6E90FA55-6EAB-4D59-B970-49B197AABB8B}&page-id={6C975D2A-B4D2-4B6C-98CE-6069987D62FA}&object-id={64D55DA0-8A44-0C47-01B2-D2D52196421E}&D5&base-path=https://d.docs.live.net/16e05d878f77e289/Documents/计算机大世界/语言/Java/面试题.one)
18.  [在 Java 中定义一个不做事且没有参数的构造方法的作用](onenote:#JavaGuide\Java基础知识.md%20&section-id={6E90FA55-6EAB-4D59-B970-49B197AABB8B}&page-id={6C975D2A-B4D2-4B6C-98CE-6069987D62FA}&object-id={64D55DA0-8A44-0C47-01B2-D2D52196421E}&DC&base-path=https://d.docs.live.net/16e05d878f77e289/Documents/计算机大世界/语言/Java/面试题.one)
19.  [import java和javax有什么区别](onenote:#JavaGuide\Java基础知识.md%20&section-id={6E90FA55-6EAB-4D59-B970-49B197AABB8B}&page-id={6C975D2A-B4D2-4B6C-98CE-6069987D62FA}&object-id={64D55DA0-8A44-0C47-01B2-D2D52196421E}&E3&base-path=https://d.docs.live.net/16e05d878f77e289/Documents/计算机大世界/语言/Java/面试题.one)
20.  接口和抽象类的区别是什么
21.  成员变量与局部变量的区别有那些
22.  [创建一个对象用什么运算符？对象实体与对象引用有何不同？](onenote:#JavaGuide\Java基础知识.md%20&section-id={6E90FA55-6EAB-4D59-B970-49B197AABB8B}&page-id={6C975D2A-B4D2-4B6C-98CE-6069987D62FA}&object-id={47FDB489-1EB0-0D3B-1A69-94967C336B95}&E&base-path=https://d.docs.live.net/16e05d878f77e289/Documents/计算机大世界/语言/Java/面试题.one)
23.  [什么是方法的返回值？返回值在类的方法里的作用是什么？](onenote:#JavaGuide\Java基础知识.md%20&section-id={6E90FA55-6EAB-4D59-B970-49B197AABB8B}&page-id={6C975D2A-B4D2-4B6C-98CE-6069987D62FA}&object-id={47FDB489-1EB0-0D3B-1A69-94967C336B95}&18&base-path=https://d.docs.live.net/16e05d878f77e289/Documents/计算机大世界/语言/Java/面试题.one)
24.  [一个类的构造方法的作用是什么 若一个类没有声明构造方法，该程序能正确执行吗](onenote:#JavaGuide\Java基础知识.md%20&section-id={6E90FA55-6EAB-4D59-B970-49B197AABB8B}&page-id={6C975D2A-B4D2-4B6C-98CE-6069987D62FA}&object-id={618E2EFD-38CF-47FB-8996-4096CCB74F4A}&E9&base-path=https://d.docs.live.net/16e05d878f77e289/Documents/计算机大世界/语言/Java/面试题.one) 为什么
25.  [构造方法有哪些特性](onenote:#JavaGuide\Java基础知识.md%20&section-id={6E90FA55-6EAB-4D59-B970-49B197AABB8B}&page-id={6C975D2A-B4D2-4B6C-98CE-6069987D62FA}&object-id={47FDB489-1EB0-0D3B-1A69-94967C336B95}&20&base-path=https://d.docs.live.net/16e05d878f77e289/Documents/计算机大世界/语言/Java/面试题.one)
26.  [静态方法和实例方法有何不同](onenote:#JavaGuide\Java基础知识.md%20&section-id={6E90FA55-6EAB-4D59-B970-49B197AABB8B}&page-id={6C975D2A-B4D2-4B6C-98CE-6069987D62FA}&object-id={47FDB489-1EB0-0D3B-1A69-94967C336B95}&34&base-path=https://d.docs.live.net/16e05d878f77e289/Documents/计算机大世界/语言/Java/面试题.one)
27.  [对象的相等与指向他们的引用相等，两者有什么不同？](onenote:#JavaGuide\Java基础知识.md%20&section-id={6E90FA55-6EAB-4D59-B970-49B197AABB8B}&page-id={6C975D2A-B4D2-4B6C-98CE-6069987D62FA}&object-id={47FDB489-1EB0-0D3B-1A69-94967C336B95}&38&base-path=https://d.docs.live.net/16e05d878f77e289/Documents/计算机大世界/语言/Java/面试题.one)
28.  [在调用子类构造方法之前会先调用父类没有参数的构造方法，其目的是？](onenote:#JavaGuide\Java基础知识.md%20&section-id={6E90FA55-6EAB-4D59-B970-49B197AABB8B}&page-id={6C975D2A-B4D2-4B6C-98CE-6069987D62FA}&object-id={47FDB489-1EB0-0D3B-1A69-94967C336B95}&3F&base-path=https://d.docs.live.net/16e05d878f77e289/Documents/计算机大世界/语言/Java/面试题.one)
29.  [== 与 equals(重要)](onenote:#JavaGuide\Java基础知识.md%20&section-id={6E90FA55-6EAB-4D59-B970-49B197AABB8B}&page-id={6C975D2A-B4D2-4B6C-98CE-6069987D62FA}&object-id={47FDB489-1EB0-0D3B-1A69-94967C336B95}&46&base-path=https://d.docs.live.net/16e05d878f77e289/Documents/计算机大世界/语言/Java/面试题.one)
30.  [hashCode 与 equals（重要）](onenote:#JavaGuide\Java基础知识.md%20&section-id={6E90FA55-6EAB-4D59-B970-49B197AABB8B}&page-id={6C975D2A-B4D2-4B6C-98CE-6069987D62FA}&object-id={92CE841A-FB3D-0E55-0F1A-A5FA91D08E42}&95&base-path=https://d.docs.live.net/16e05d878f77e289/Documents/计算机大世界/语言/Java/面试题.one)

1.  hashCode（）介绍
2.  为什么要有 hashCode
3.  hashCode（）与equals（）的相关规定

32.  [为什么Java中只有值传递](onenote:#JavaGuide\Java基础知识.md%20&section-id={6E90FA55-6EAB-4D59-B970-49B197AABB8B}&page-id={6C975D2A-B4D2-4B6C-98CE-6069987D62FA}&object-id={92CE841A-FB3D-0E55-0F1A-A5FA91D08E42}&B1&base-path=https://d.docs.live.net/16e05d878f77e289/Documents/计算机大世界/语言/Java/面试题.one)
33.  [简述线程，程序、进程的基本概念。以及他们之间关系是什么](onenote:#JavaGuide\Java基础知识.md%20&section-id={6E90FA55-6EAB-4D59-B970-49B197AABB8B}&page-id={6C975D2A-B4D2-4B6C-98CE-6069987D62FA}&object-id={92CE841A-FB3D-0E55-0F1A-A5FA91D08E42}&B7&base-path=https://d.docs.live.net/16e05d878f77e289/Documents/计算机大世界/语言/Java/面试题.one)
34.  [线程有哪些基本状态？这些状态是如何定义的?](onenote:#JavaGuide\Java基础知识.md%20&section-id={6E90FA55-6EAB-4D59-B970-49B197AABB8B}&page-id={6C975D2A-B4D2-4B6C-98CE-6069987D62FA}&object-id={92CE841A-FB3D-0E55-0F1A-A5FA91D08E42}&C3&base-path=https://d.docs.live.net/16e05d878f77e289/Documents/计算机大世界/语言/Java/面试题.one)
35.  [关于 final 关键字的一些总结](onenote:#JavaGuide\Java基础知识.md%20&section-id={6E90FA55-6EAB-4D59-B970-49B197AABB8B}&page-id={6C975D2A-B4D2-4B6C-98CE-6069987D62FA}&object-id={92CE841A-FB3D-0E55-0F1A-A5FA91D08E42}&C9&base-path=https://d.docs.live.net/16e05d878f77e289/Documents/计算机大世界/语言/Java/面试题.one)
36. Java 中的异常处理

1.  Java异常类层次结构图
2.  Trowable类常用方法
3.  异常处理总结

38.  Java序列话中如果有些字段不想进行序列化 怎么办
获取用键盘输入常用的的两种方法

StringTokenizer是什么