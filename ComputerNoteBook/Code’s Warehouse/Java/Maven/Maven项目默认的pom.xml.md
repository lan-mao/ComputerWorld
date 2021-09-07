---
title: Maven项目默认的pom.xml
date: 2021-09-06 09:49
tags:
  - Code/框架/Java/Maven
  - Code/框架/Java/SpringBoot
  - Code/语言/XML
  - Code/分类/项目开发
  - Spring/SpringBoot
alias: null
category: null
description: null
from: null
modified: 2021-09-06 10:16

---

# Maven项目默认的pom.xml

> 添加了SpringBoot的依赖管理组件，并添加SpringBoot的初始化依赖。可作为SpringBoot项目的父项目。
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>top.lan-mao.ComputerWorld</groupId>
    <artifactId>demo</artifactId>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
    </dependencies>

    <properties>
        <springframework.version>2.5.4</springframework.version>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    </properties>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-parent</artifactId>
                <version>${springframework.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

</project>
```
