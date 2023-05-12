module web.frame.spring.redis {

    requires static lombok;
    requires redisson.spring.data23;
    requires com.fasterxml.jackson.databind;
    requires spring.data.redis;
    requires spring.context;
    requires org.slf4j;
    requires java.annotation;

    exports com.cloud.frame.spring.redis;
}