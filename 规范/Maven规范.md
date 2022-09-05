# Maven项目规则

## Maven官网的命名规范

**Guide to naming conventions on groupId, artifactId, and version**

- **groupId** uniquely identifies your project across all projects. A group ID should follow Java's package name rules. This means it starts with a reversed domain name you control. For example,

    `org.apache.maven, org.apache.commons`

    Maven does not enforce this rule. There are many legacy projects that do not follow this convention and instead use single word group IDs. However, it will be difficult to get a new single word group ID approved for inclusion in the Maven Central repository.

    You can create as many subgroups as you want. A good way to determine the granularity of the groupId is to use the project structure. That is, if the current project is a multiple module project, it should append a new identifier to the parent's groupId. For example,

    `org.apache.maven, org.apache.maven.plugins, org.apache.maven.reporting`

- **artifactId** is the name of the jar without version. If you created it, then you can choose whatever name you want with lowercase letters and no strange symbols. If it's a third party jar, you have to take the name of the jar as it's distributed.

    eg. `maven, commons-math`

- **version** if you distribute it, then you can choose any typical version with numbers and dots (1.0, 1.1, 1.0.1, ...). Don't use dates as they are usually associated with SNAPSHOT (nightly) builds. If it's a third party artifact, you have to use their version number whatever it is, and as strange as it can look. For example,

    `2.0, 2.0.1, 1.3.1`

### 对应含义

总的来说：

groupId:定义当前Maven项目隶属的实际项目，例如 org.sonatype.nexus，此id前半部分org.sonatype代表此项目隶属的组织或公司，后部分代表项目的名称，如果此项目多模块话开发的话就子模块可以分为org.sonatype.nexus.plugins和org.sonatype.nexus.utils等。 特别注意的是groupId不应该对应项目隶属的组织或公司，也就是说groupId不能只有org.sonatype而没有nexus。

例如：我建立一个项目，此项目是此后所有项目的一个总的平台，那么groupId应该是org.limingming.projectName,projectName是平台的名称，org.limingming是代表我个人的组织，如果以我所在的浪潮集团来说的话就应该是com.inspur.loushang。

artifactId是构件ID，该元素定义实际项目中的一个Maven项目或者是子模块，如上面官方约定中所说，构建名称必须小写字母，没有其他的特殊字符，推荐使用“实际项目名称－模块名称”的方式定义，例如：spirng-mvn、spring-core等。
推荐格式：使用实际项目名称作为artifactId的前缀，紧接着为模块名称
举例：nexus-indexer、spring-mvc、hibernate-c3po……这些id都是以实际项目名称作为前缀，然后接着一个中划线，再紧跟项目的模块名称，默认情况下maven会在artifactId添加version作为最后生成的名称。例如：spirng-mvn-2.0.0.jar

## 整体规范

1. 整体命名规范
   1. 所有字符均用小写字母、下划线 `_` 、横线 `-`
   2. 开始均为`top.lan-mao`
   3. 同一层级中的单词等分割使用`_`
   4. 不同层级中的单词分割使用 `-`
2. `groupId`
   1. 整个项目为：`top.lan-mao.computer_world`
   2. 子项目为：`top.lan-mao.computer_world.study_2022`
   3. 子项目中的子项目的 `groupId` 与对应父项目保持一致，为： `top.lan-mao.computer_world.study_2022`
3. `artifactId`
   1. 整个项目：`computer_world`
   2. 子项目：`study_2022`
   3. 子项目中的子项目： `zuo_data_structure_and_algorithm`
4. `version`
   1. 默认均使用 `1.0-SNAPSHOT`
   2. 对于有版本需求，需要发布的，使用 `1.0` 等
5. pom文件规范
   1. 对于有父子关系的项目，需使用 `parent`和 `modules` 标签记录标记下
   2. 对于没有实际代码，只起归纳作用的父项目，pom文件类型为`pom`，即设置：`<packaging>pom</packaging>`
6. 示例，使用`groupId : artifactId`方式表示
   1. top.lan-mao.computer_world : computer_world
   2. top.lan-mao.computer_world : leet_code
   3. top.lan-mao.computer_world.study_2022 : study_2022
   4. top.lan-mao.computer_world.study_2022 : mall
   5. top.lan-mao.computer_world.study_2022.mall : mall-user



## 资料参考

- [maven官网文档中的命名约定指南](https://maven.apache.org/guides/mini/guide-naming-conventions.html)
- <https://blog.csdn.net/limm33/article/details/60959044>