module web.frame.spring.redis {

    requires spring.data.redis;
    requires redisson.spring.data23;
    requires spring.context;
    requires com.fasterxml.jackson.databind;

    exports com.cloud.frame.spring.redis;
}