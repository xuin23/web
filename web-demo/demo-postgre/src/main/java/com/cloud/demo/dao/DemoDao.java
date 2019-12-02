package com.cloud.demo.dao;

import com.cloud.demo.module.AuthUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface DemoDao {

    @Select("select * from web.auth_user")
    public List<AuthUser> getAuthUser();

}
