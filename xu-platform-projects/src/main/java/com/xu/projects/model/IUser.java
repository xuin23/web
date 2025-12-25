package com.xu.projects.model;


public interface IUser {

    Long getId();

    String getLoginName();

    String getName();

    String getLabel();

    void setName(String var1);

    String getEmail();

    void setEmail(String var1);

    String  getDescription();

    void setDescription(String  var1);

    String getInitials();

    void setInitials(String var1);

    boolean isDisabled();

    String getHomePageContent();

    void setHomePageContent(String  text);
}
