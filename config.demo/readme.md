配置中心选型
springboot为了实现推送和高可用需要加入服务注册和发现以及通过消息队列推送给客户端拉取配置的方式。
但是当前项目优先使用配置管理的功能。
将当前实例作为一个基本的配置中心，能够拉取，统一维护一个项目对应的配置即可。
```sh
├── configclient
│   └── src
│       ├── main
│       │   ├── java  源代码
│       │   └── resources
│       │       ├── application.properties  本地项目遗爱
│       │       ├── bootstrap.yml 启动前的依赖
│       └── test
│           └── java 源文件
├── configserver
│   ├── readme.md 服务端说明文件
│   └── src
│       ├── main
│       │   ├── java  源代码
│       │   └── resources
│       │       ├── application.properties
│       └── test
└── readme.md
```