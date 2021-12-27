module web.frame.spring.redis {

    requires static lombok;
    requires redisson.spring.data23;
    requires com.fasterxml.jackson.databind;
    requires spring.data.redis;
    requires spring.context;
    requires org.slf4j;

    exports com.cloud.frame.spring.redis;
}