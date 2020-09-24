# Spring Cloud 微服务项目简单搭建

 >本项目使用了 lombok ，如果用IDE打开时发现多出报错（此时可直接启动），在IDE安装对应的Lombok插件即可

## 基本架构

1 主要模块

模块|模块名|作用
---|--- | ---
web-common|公共包|公共依赖
web-auth|权限服务|主要业务
web-message|消息服务|邮箱发送
web-operator|操作服务|操作入口
web-gateway|gateway|路由

2 基本架构

2.1 后端

名称|版本号
---|---
OpenJDK|11
SpringBoot|2.3.2.RELEASE
SpringCloud|Hoxton.SR6
Postgres|
Redis|
Rabbitmq|
