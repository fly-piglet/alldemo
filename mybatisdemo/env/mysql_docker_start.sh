#!/usr/bin/env bash

container_name="mybatisdemo-mysql"
# 数据库端口
mysql_port="3309"
# 数据库密码
mysql_root_password="root"
# 启动数据库，设定用户名密码，设定字符集，设定不区分大小写
docker run -di --name=${container_name} \
--restart=always \
-p ${mysql_port}:3306 \
-e MYSQL_ROOT_PASSWORD=${mysql_root_password} \
mysql:5.7.25 --character-set-server=utf8 --collation-server=utf8_general_ci --lower_case_table_names=1
