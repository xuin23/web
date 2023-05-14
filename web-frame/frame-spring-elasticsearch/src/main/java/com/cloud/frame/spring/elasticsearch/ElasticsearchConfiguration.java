package com.cloud.frame.spring.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchConfiguration {

    @Value("${elasticsearch.host}")
    private String host;

    @Value("${elasticsearch.port}")
    private int port;

    @Value("${elasticsearch.connTimeout}")
    private int connTimeout;

    @Value("${elasticsearch.socketTimeout}")
    private int socketTimeout;

    @Value("${elasticsearch.connectionRequestTimeout}")
    private int connectionRequestTimeout;

//    @Bean
//    public RestClient initRestClient() {
//        RestClientBuilder builder = RestClient.builder(new HttpHost(host, port))
//                .setRequestConfigCallback(requestConfigBuilder -> requestConfigBuilder
//                        .setConnectTimeout(connTimeout)
//                        .setSocketTimeout(socketTimeout)
//                        .setConnectionRequestTimeout(connectionRequestTimeout));
//        RestClient build = builder.build();
//        return builder.build();
//    }

}