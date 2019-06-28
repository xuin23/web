### 基于SpringCloud 的权限管理
### 开发中，敬请期待
##### 涉及内容
###### 后端（开发中）
* RBAC(ROLE-BASED ACCESS CONTROL) 权限模型实现
* SpringCloud Feign
* SpringCloud Eureka
* ~~SpringCloud Oauth2~~
* SpringCloud GateWay
* Redis
* ~~RabbitMq~~
* MySQL
* Mybatis
* SpringBoot
* docker
###### ~~前端~~(未开工)
* ~~vue~~
* ~~Vue Router~~
* ~~axios~~


##### 主要模块
* eureka（注册中心）
* common（公共包）
* auth（权限服务）
* operator（操作服务，暴露在外）
* sms（消息服务）
* gateway（路由）
* ~~config（统一配置）~~

#### 运行步骤 
* 安装MySQL 5.7
* 执行/init/initDataBase.sql文件初始化数据库
* 安装启动Redis
* 安装启动RabbitMq
* 启动eureka服务
* 启动gateway服务
* 启动auth-core服务
* 启动operator服务
* 启动sms-core服务

#### 清除数据

* 执行/init/dropDataBase.sql清除本项目创建的数据

#### 已实现功能

* 用户表 增删改查
* 发送邮箱验证码
* 邮箱验证码登录