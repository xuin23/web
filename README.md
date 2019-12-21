###### 后端
* Openjdk13
* RBAC(ROLE-BASED ACCESS CONTROL) 权限模型实现
* SpringCloud Feign
* SpringCloud Eureka
* SpringCloud GateWay
* Redis
* RabbitMq
* Postgres
* Mybatis
* SpringBoot
###### 前端
* vue
* Vue Router
* ElementUi
* axios

###### 主要模块
* common（公共包）
* eureka（注册中心）
* auth（权限服务）
* message（消息服务）
* operator（操作服务）
* gateway（路由）

###### 运行步骤 
* 安装Postgres 12
* 执行/init/initPostgersDataBase.sql文件初始化数据库
* 执行/init/initdata.sql初始化数据
* 安装启动Redis
* 安装启动RabbitMq
* 启动eureka服务
* 启动gateway服务
* 启动auth-core服务
* 启动operator服务
* 启动message-core服务

###### 已实现功能

* 用户表 增删改查
* 发送邮箱验证码
* 邮箱验证码登录
