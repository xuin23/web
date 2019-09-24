package com.cloud.auth.core.config;

import com.cloud.auth.core.execption.CustomWebResponseExceptionTranslator;
import com.cloud.auth.core.service.UserDetailService;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@EnableResourceServer
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    private static final String DEMO_RESOURCE_ID = "order";

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private RedisConnectionFactory redisConnectionFactory;

    @Resource
    private UserDetailService userDetailService;

    @Resource
    private CustomWebResponseExceptionTranslator webResponseExceptionTranslator;

    /**
     * 数据源
     */
    @Resource
    private DataSource dataSource;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

//        String finalSecret = DigestUtil.encodeByMd5("123456");
//        String finalSecret = "{bcrypt}" + new BCryptPasswordEncoder().encode("123456");
        // 配置两个客户端，一个用于password认证一个用于client认证
        //默认token的有效期为12小时
        clients.jdbc(dataSource).passwordEncoder(new MyPasswordEncoder());

//        clients.inMemory()
////                .withClient("client_1")//基于客户端认证的
//////                .resourceIds(DEMO_RESOURCE_ID)
////                .authorizedGrantTypes("client_credentials", "refresh_token")
////                .scopes("select")
////                .authorities("oauth2")
////                .secret(finalSecret)
////                .and()
//                .withClient("client_2")
////                .resourceIds(DEMO_RESOURCE_ID)
//                .authorizedGrantTypes("password", "refresh_token")
////                .scopes("select")
////                .authorities("oauth2")
//                .secret("123456");

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(new RedisTokenStore(redisConnectionFactory))//token存储在redis中
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailService);//密码模式需要在数据库中进行认证
        endpoints.exceptionTranslator(webResponseExceptionTranslator);// 错误异常
//                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // 允许表单认证
        security.allowFormAuthenticationForClients()
//                .tokenKeyAccess("permitAll()")
//                .checkTokenAccess("isAuthenticated()")
        ;
    }
}
