module com.cloud.service.auth {
    requires spring.data.jpa;
    requires spring.cloud.commons;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.boot;
    requires spring.beans;
    requires spring.web;
    requires spring.data.commons;
    requires static lombok;

    requires java.transaction;
    requires java.annotation;

    requires redisson;
    requires spring.data.redis;
    requires web.common;
    requires java.persistence;
    requires java.desktop;

    requires web.frame.spring.redis;
    requires web.frame.spring.jpa;
    requires web.auth.entity;


}