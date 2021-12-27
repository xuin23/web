# Spring Cloud 微服务项目简单搭建

## 基本架构

### 1、基本架构

    * OpenJDK 17
    * Spring Boot
    * Spring Cloud
    * Postgres
    * Rabbitmq
    * Redis

### 2、主要模块

    * web-common
    * web-entity
        * auth-entity
    * web-frame
        * frame-spring-jpa
        * frame-spring-redis
    * web-service
        * service-auth
        * service-gateway
        * service-message

### 3、启动

#### Ubuntu 20 环境

* [安装Powershell](https://docs.microsoft.com/zh-cn/powershell/scripting/install/installing-powershell-core-on-linux?view=powershell-7.1)（就是想用Powershell）
* 配置openjdk16 环境变量（紧跟JDK最新版）
* 配置Maven环境变量
* 安装Docker
* 安装docker-compose
* 安装Git
* git clone https://github.com/xuin23/web.git
* cd web
* pwsh ./init.ps1 等待启动
* 启动完成后 执行curl http://localhost:8080/auth/authUser 若返回一串json数据即代表服务整体启动成功

> 启动完成后会在docker中启动一个redis，一个postgres（已完成数据库初始化），一个rabbitmq，一个consul，一个nginx。另外会启动一个gateway服务，三个auth-core服务，三个message-core。待项目整体完善后使用nginx代理8080端口服务
>
>  数据在/data文件夹
