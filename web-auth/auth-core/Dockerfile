# 基础镜像
FROM openjdk:11.0.8
# 对应pom.xml文件中的dockerfile-maven-plugin插件JAR_FILE的值
ARG JAR_FILE
# 复制打包完成后的jar文件到/opt目录下
COPY ${JAR_FILE} /${JAR_FILE}
# 启动容器时执行
ENTRYPOINT ["java","-jar","/${JAR_FILE}"]
EXPOSE 8080