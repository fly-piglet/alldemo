### 快速开始
#### 项目说明模块介绍
maven多模块的mybatis gennerator生成案例，使用springboot创建使用springboot2.1版本，添加mybatis起步依赖，数据库脚本，添加最简单的单元测试
```sh
├── genpj.generator
│   ├── pom.xml 生成器插件配置
│   └── src
│       └── main
│           └── resources   生成器插件配置，依赖配置，数据库脚本
├── genpj.mainpj
│   ├── pom.xml
│   └── src
│       ├── main
│       │   ├── java    源代码
│       │   └── resources   springboot配置，以及mainpj mapper存放位置
│       └── test
│           └── java    mainpj单元测试，是主要项目的启动工程，所以使用springboot进行单元测试
├── genpj.module
│   ├── pom.xml
│   └── src
│       ├── main
│       │   ├── java    源代码
│       │   └── resources   modulemapper存放位置
│       └── test
│           └── java    module单元测试：引入mybatis做单元测试，不含有spring
├── pom.xml 项目工程pom
├── sqlscript   数据库初始化脚本
└── readme.md   帮助文档
```

#### 生成命令
选择命令运行在genpj.generator模块工程下运行

生成命令
* ``mvn mybatis-generator:generate``

覆盖生成命令
* ``mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate``

### 配置标签分类说明：
**全局配置**
数据库驱动：classPathEntry：使用maven注入依赖可以不使用
配置文件：properties: 添加外部配置文件支持
连接工厂：connectionFactory
属性：property
排除：except
环境：context
插件：plugin

**类对象配置**
实体对象命名规则：domainObjectRenamingRule
生成配置：generatorConfiguration
备注创建：commentGenerator
java客户端生成：javaClientGenerator
java实体类生成：javaModelGenerator
java类型转换：javaTypeResolver
sql映射xml生成：sqlMapperGenerator
需要生成的表配置：table

**字段配置**
id字段生成：generatedKey
忽略字段：ignoreColumn
正则忽略字段：ignoreColumnsByRegex
字段覆盖：columnOverride
字段重命名规则：columnRenamingRule

### 参考：
[MyBatis Generator Core – Introduction to MyBatis Generator](http://www.mybatis.org/generator/index.html)

[mybatis – MyBatis 3 | 简介](http://www.mybatis.org/mybatis-3/zh/index.html)

