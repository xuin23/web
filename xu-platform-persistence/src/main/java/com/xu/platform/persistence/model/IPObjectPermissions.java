package com.xu.platform.persistence.model;

public interface IPObjectPermissions {

    boolean read();

    boolean modify();

    boolean delete();

    boolean readKey(String var1);

    boolean modifyKey(String var1);

}
