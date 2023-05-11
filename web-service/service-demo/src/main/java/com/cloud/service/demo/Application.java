package com.cloud.service.demo;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

@ComponentScan(basePackages = {"com.cloud"})
@SpringBootApplication
@RestController
public class Application {

    @Resource
    RestHighLevelClient restHighLevelClient;


    @GetMapping
    public Object o() throws IOException {
        //1. 创建Request对象
        SearchRequest request = new SearchRequest("logstash-%{+YYYY.MM.dd}");

        //2. 指定查询条件
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.from(0);
        builder.size(5);
        builder.query(QueryBuilders.termQuery("@timestamp",""));

        request.source(builder);

        //3. 执行查询
        SearchResponse resp = restHighLevelClient.search(request, RequestOptions.DEFAULT);

        //4. 获取到_source中的数据，并展示
        for (SearchHit hit : resp.getHits().getHits()) {
            Map<String, Object> result = hit.getSourceAsMap();
            System.out.println(result);
        }
        return null;
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
