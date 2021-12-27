module web.frame.spring.common {

    requires static lombok;
    requires org.slf4j;
    requires spring.context;
    requires spring.beans;
    requires spring.web;
    requires web.common;

    exports com.cloud.frame.spring.common;
}