module web.frame.spring.redis {
    requires spring.data.commons;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires redisson.spring.data23;
    requires spring.context;
    requires spring.data.redis;

    exports com.cloud.frame.spring.redis;
}