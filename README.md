本项目使用了 lombok ，如果用IDE打开时发现多出报错（此时可直接启动），安装对应的Lombok插件即可

###### 后端
名称|版本号
---|---
OpenJDK|11
SpringBoot|2.2.1.RELEASE
SpringCloud|Hoxton.RELEASE
Postgres|
Redis|
Rabbitmq|
###### 前端
名称|使用
---|--- 
框架|vue
路由|Vue Router
UI库|ElementUi
http库|axios
###### 主要模块
模块|模块名|作用
---|--- | ---
web-common|公共包|公共依赖
web-auth|权限服务|主要业务
web-message|消息服务|邮箱发送
web-operator|操作服务|操作入口
web-gateway|路由|类似nginx功能

##### restful 风格
>例如：authUser 

操作|url|请求类型
---|--- | ---
ID查询|/authUser/1|GET
根据ID删除|/authUser/1|DELETE
查询所有|/authUser|GET
修改（ID必填）|/authUser|PUT
新增|/authUser|POST
