#mkdir -p /data/elasticsearch/data
#mkdir -p /data/logstash/

#cp logstash.conf /data/logstash/

Write-Host("执行docker-compose 创建elk容器(elasticsearch、kibana、logstash)")
docker-compose up -d