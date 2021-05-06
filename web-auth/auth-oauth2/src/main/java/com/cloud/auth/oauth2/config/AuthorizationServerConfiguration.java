package com.cloud.auth.oauth2.config;

import org.redisson.spring.data.connection.RedissonConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * AuthorizationServerConfiguration
 *
 * @author xulijian
 */
@Configurable
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    /**
     * 数据源
     */
    @Autowired
    private DataSource dataSource;


    /**
     * UserDetailService
     */
    @Autowired
    public UserDetailService userDetailService;

    /**
     * RedisConnectionFactory
     */
    @Autowired
    public RedissonConnectionFactory redissonConnectionFactory;

    /**
     * MD5密码加密
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new MD5PasswordEncoder();
    }


    /**
     * ClientDetails实现
     */
    @Bean
    public ClientDetailsService clientDetails() {
        return new JdbcClientDetailsService(dataSource);
    }

    /**
     * TokeStore
     *
     * @return JdbcTokenStore
     */
    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }

    /**
     * 加入对授权码模式的支持
     *
     * @param dataSource 数据源
     * @return AuthorizationCodeServices
     */
    @Bean
    public AuthorizationCodeServices authorizationCodeServices(DataSource dataSource) {
        return new JdbcAuthorizationCodeServices(dataSource);
    }


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(new JdbcClientDetailsService(dataSource));
    }

    /**
     * 声明授权和token的端点以及token的服务的一些配置信息，
     * 比如采用什么存储方式、token的有效期等
     *
     * @param endpoints AuthorizationServerEndpointsConfigurer
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
                // .tokenStore(new RedisTokenStore(redisConnectionFactory))  // 使用redis的配置
                .tokenStore(new JdbcTokenStore(dataSource))
                .authenticationManager(new OAuth2AuthenticationManager())
                .userDetailsService(userDetailService);
//                .authorizationCodeServices(authorizationCodeServices)
//                .setClientDetailsService(clientDetailsService);

    }


    /**
     * 声明安全约束，哪些允许访问，哪些不允许访问
     *
     * @param oauthServer AuthorizationServerSecurityConfigurer
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        // 允许表单认证
        oauthServer.allowFormAuthenticationForClients();
        // 配置BCrypt加密
        oauthServer.passwordEncoder(new MD5PasswordEncoder());
        // 对于CheckEndpoint控制器[框架自带的校验]的/oauth/check端点允许所有客户端发送器请求而不会被Spring-security拦截
        oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
        // 此处可添加自定义过滤器，对oauth相关的请求做进一步处理
        // oauthServer.addTokenEndpointAuthenticationFilter(new Oauth2Filter());
    }

}
