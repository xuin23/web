module web.frame.spring.common {

    requires static lombok;
    requires org.slf4j;
    requires spring.context;
    requires spring.beans;
    requires spring.web;
    requires spring.aop;
    requires org.aspectj.weaver;
    requires web.common;
    requires spring.boot.autoconfigure;

    exports com.cloud.frame.spring.common;
}