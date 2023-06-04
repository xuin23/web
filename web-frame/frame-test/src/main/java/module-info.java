module web.frame.spring.redis {

    requires static lombok;
    requires com.fasterxml.jackson.databind;
    requires spring.data.redis;
    requires spring.context;
    requires org.slf4j;
    requires jakarta.annotation;
    requires redisson.spring.data27;

    exports com.cloud.frame.spring.redis;
}