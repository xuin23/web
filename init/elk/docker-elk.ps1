# mkdir -p elasticsearch/data
# mkdir -p elasticsearch/plugins
mkdir -p logstash/

cp logstash.conf logstash/

Write-Host("执行docker-compose 创建elk容器(elasticsearch、kibana、logstash)")
docker-compose up -d