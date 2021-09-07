---
title: Java开发手册学习笔记
date: 2021-08-29 19:04
tags:
  - null
alias: null
category: null
stars: null
from: null
url: null
references: null
modified date: null
modified: 2021-08-31 23:01

---

# Java开发手册学习笔记

## 零、整理合集

### （一）、应用分层及编写规约

1. 应用分层
   ![[Pasted image 20210829180750.png]]

   - 终端显示层（View）：各个模板渲染并显示的层
   - Web层：处理访问控制进行转发，各类参数校验，不复用的简单业务处理
   - Service层：具体的业务逻辑处理
   - Manager层：通用业务处理，如：
     - 对Service层通用能力的下沉，如缓存方案，中间件通用处理等。
     - 与DAO层交互，对多个DAO的组合服用
     - 对第三方平台封装，预处理返回结果及转化异常信息
   - Dao层：数据访问层，与底层数据存储系统交互
   - 开放API层：可以直接封装Service接口暴露成RPC接口，或通过Web封装乘http接口，网关控制层等

2. 各层数据模型命名规约
   - POJO是DO/DTO/BO/VO的统称，禁止命名为xxxPOJO
   - DO（Data Object）：此对象与数据库表结构一一对应，通过 DAO 层向上传输数据源对象。
   - DTO（Data Transfer Object）：数据传输对象，Service 或 Manager 向外传输的对象。
   - BO（Business Object）：业务对象，可以由 Service 层输出的封装业务逻辑的对象。
   - Query：数据查询对象，各层接收上层的查询请求。注意超过 2 个参数的查询封装，禁止使用 Map 类来传输。
   - VO（View Object）：显示层对象，通常是 Web 向模板渲染引擎层传输的对象。

## 一、编程规约

### （一）、命名风格

1. 类名命名规范：
   1. 类名使用UpperCamelCase风格，除了DO/BO/DTO/VO/AO/PO/UID等大写缩写
   2. 抽象类使用Abstract开头，异常类以Exception结尾，测试类以要测试的类名开头以Test结尾。
   3. POJO类中的布尔类型变量，都不加is前缀，对于需要与数据库中表字段映射的DO类
   4. 各层模型类命名规约：
      1. 数据库映射类：xxxDO
      2. Service层输出类：xxxBO（Business Object，业务对象）
      3. WEB层向模板渲染层传输类：xxxVO
      4. Manager层：xxxAO（Application Object），对Service层中独立出来的

### （四）、OOP规约
