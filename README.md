# Spring Cloud 微服务项目简单搭建

 >本项目使用了 lombok ，如果用IDE打开时发现多出报错（此时可直接启动），在IDE安装对应的Lombok插件即可

## 基本架构

1 主要模块

模块|模块名|作用
---|--- | ---
common|公共包|公共依赖
auth|权限服务|主要业务
message|消息服务|邮箱发送
operator|操作服务|操作入口
gateway|路由|类似nginx功能

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

2.2 前端

名称|使用
---|---
框架|vue
路由|Vue Router
UI库|ElementUi
http库|axios

2.3 restful 风格

>例如：authUser

操作|url|请求类型
---|--- | ---
查询所有|/authUser|GET
查询所有|/authUser/list|GET
ID查询|/authUser/1|GET
修改（ID必填）|/authUser|PUT
新增|/authUser|POST
根据ID删除|/authUser/1|DELETE
