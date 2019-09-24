package com.cloud.demo.oauth2.server.service;

import com.cloud.auth.entity.AuthUser;
import com.cloud.demo.oauth2.server.module.UserDetail;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * springSecurity UserDetailService
 */
@Service
public class UserDetailService implements UserDetailsService {

    /**
     * 用户 service
     */
    @Resource
    private AuthUserService authUserService;

    /**
     * 授权的时候是对角色授权，而认证的时候应该基于资源，而不是角色，因为资源是不变的，而用户的角色是会变的
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser authUser = authUserService.findByEmail(username);
        if (null == authUser) {
            throw new RuntimeException("当前用户不存在！");
        }
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority("auth_"));
//        return new User(authUser.getUsername(), authUser.getPassword(), authorities);
        return new UserDetail(authUser.getId(), authUser.getEmail(), authUser.getPassword(), authUser.getEmail());
    }
}
