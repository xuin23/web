module web.auth.entity {
    requires static lombok;

    requires java.persistence;
    requires org.hibernate.orm.core;
    requires web.frame.spring.jpa;

    requires spring.data.jpa;
    requires spring.data.commons;
    requires spring.context;

    exports com.cloud.eneity.auth.entity;
    exports com.cloud.eneity.auth.repo;

}