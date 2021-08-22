module web.auth.entity {
    requires java.persistence;
    requires static lombok;
    requires spring.data.jpa;
    requires org.hibernate.orm.core;
    requires spring.data.commons;
    requires spring.context;

    requires web.frame.spring.jpa;


    exports com.cloud.eneity.auth.entity;
    exports com.cloud.eneity.auth.repo;

}