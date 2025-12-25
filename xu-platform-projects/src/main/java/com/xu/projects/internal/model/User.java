package com.xu.projects.internal.model;

import com.xu.platform.persistence.spi.PObject;
import com.xu.projects.model.IUser;
import jakarta.persistence.Table;

@Table(name = "t_user")
public class User extends PObject implements IUser {

    private Long id;
    private String loginName;
    private String name;
    private String label;
    private String email;
    private String description;
    private String initials;
    private boolean disabled;
    private String homePageContent;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getInitials() {
        return initials;
    }

    @Override
    public void setInitials(String initials) {
        this.initials = initials;
    }

    @Override
    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    @Override
    public String getHomePageContent() {
        return homePageContent;
    }

    @Override
    public void setHomePageContent(String homePageContent) {
        this.homePageContent = homePageContent;
    }
}
