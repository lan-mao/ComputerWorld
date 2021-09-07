---
title: 在项目中添加Spring Boot依赖
date: 2021-09-04 10:58
tags:
  - null
alias: null
category: null
description: null
from: https://www.malaoshi.top/show_1EF5qXhI66uM.html
modified: 2021-09-04 10:59

---

# 在项目中添加Spring Boot依赖

## 方式一：添加2个依赖（推荐）

这种方式不需要继承Spring Boot的父工程，方便后续扩展。

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-dependencies</artifactId>
            <version>2.2.2.RELEASE</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <!-- 不需要加版本号 -->
    </dependency>
</dependencies>
```

完整