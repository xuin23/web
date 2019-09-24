package com.cloud.demo.oauth2.server.config;


import com.cloud.demo.oauth2.server.execption.CustomWebResponseExceptionTranslator;
import com.cloud.demo.oauth2.server.module.UserDetail;
import com.cloud.demo.oauth2.server.service.UserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

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

    @Bean
    public TokenStore redisToken() {
        return new RedisTokenStore(redisConnectionFactory);
    }

    /**
     * 定义jwt的生成方式
     *
     * @return JwtAccessTokenConverter
     */
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter() {
            @Override
            public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
                final Map<String, Object> additionalInformation = new HashMap<>();
                UserDetail userModel = (UserDetail) authentication.getUserAuthentication().getPrincipal();
                //把用户的主键uin放进去
                additionalInformation.put("id", userModel.getId());
                ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInformation);
                return super.enhance(accessToken, authentication);
            }
        };
        //非对称加密，但jwt长度过长
//        KeyPair keyPair = new KeyStoreKeyFactory(new ClassPathResource("kevin_key.jks"), "123456".toCharArray())
//                .getKeyPair("kevin_key");
//        converter.setKeyPair(keyPair);
//        return converter;
        //对称加密
        converter.setSigningKey("123");
        return converter;
    }


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        InMemoryClientDetailsServiceBuilder builder = clients.inMemory();
        builder.withClient("client").secret("secret")
                //设置token有效期
                .accessTokenValiditySeconds(7 * 24 * 3600)
                //设置refreshToken有效期
                .refreshTokenValiditySeconds(7 * 24 * 3600)
                //支持的认证方式
                .authorizedGrantTypes("refresh_token", "authorization_code", "password").autoApprove(false)
                //授权域
                .scopes("app", "write");


    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(new RedisTokenStore(redisConnectionFactory))//token存储在redis中
                .authenticationManager(authenticationManager)
                .reuseRefreshTokens(false)
                .accessTokenConverter(accessTokenConverter())
                .userDetailsService(userDetailService);//密码模式需要在数据库中进行认证
//        endpoints.exceptionTranslator(webResponseExceptionTranslator);// 错误异常
//                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // 允许表单认证
        security.allowFormAuthenticationForClients();
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }
}
