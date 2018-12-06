创建一个单实例的配置中心：使用docker启动
在系统启动前能够拉取配置：每个项目服务器获取
通过统一的界面来管理配置的修改：通过git加文件夹来管理
启动docker实例的时候，通过环境标记来获取配置，不需要手动配置：动态拉取配置，本地默认不拉取，使用配置来配置

这样做的有点：
1. 统一了配置的中心
2. 统一维护的地方
3. 解决docker启动没有配置的问题

测试接口：
本地测试：
#/{application}/{profile}[/{label}]
#/{application}-{profile}.yml
#/{label}/{application}-{profile}.yml
#/{application}-{profile}.properties
#/{label}/{application}-{profile}.properties

# 主分支获取
http://localhost:8080/config-dev.properties
# tag获取
http://localhost:8080/V1.0.0/config-dev.properties
# 分支后去
http://localhost:8080/feature/config-dev.properties
# 提交获取
http://localhost:8080/1de3fff98d0a716a71e46b11a598f47a6f3e5a94/config-dev.properties
http://localhost:8080/1de3fff/config-dev.properties

# yml文件没有的情况下，会通过application.properties来进行转换
# yml文件获取
http://localhost:8080/config-dev.yml
# 也支持tag、分支、提交
http://localhost:8080/V1.0.0/config-dev.yml

# 类似监控访问env的配置，是一个整体的配置
http://localhost:8080/config/dev[/V1.0.0]




