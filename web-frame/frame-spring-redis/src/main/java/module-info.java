module web.frame.spring.redis {

    requires static lombok;
    requires org.slf4j;
    requires redisson.spring.data23;
    requires spring.data.redis;
    requires spring.context;
    requires com.fasterxml.jackson.databind;

    exports com.cloud.frame.spring.redis;
}