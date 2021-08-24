module web.frame.spring.jpa {
    requires static lombok;
    requires org.slf4j;
    requires org.hibernate.orm.core;
    requires spring.data.commons;
    requires spring.data.jpa;
    requires java.persistence;

    exports com.cloud.frame.spring.jpa;
}