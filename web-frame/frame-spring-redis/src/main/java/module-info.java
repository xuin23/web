module web.frame.spring.redis {

    requires static lombok;
    requires com.fasterxml.jackson.databind;
    requires spring.data.redis;
    requires spring.context;
    requires org.slf4j;
    requires jakarta.annotation;
    requires org.aspectj.weaver;
    requires redisson.spring.data27;
    requires redisson;

    exports com.cloud.frame.spring.redis;
}