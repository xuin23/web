Write-Host "Docker 远程Web服务创建中。。。。。"
docker run -d  --restart always  --name docker-web -p 9000:9000 -v /var/run/docker.sock:/var/run/docker.sock uifd/ui-for-docker
Write-Host "Docker 远程Web服务创建完成。。。。。"

Write-Host "Redis 服务创建中。。。。。"
mkdir -p /data/redis
docker run -d  --restart always -p 6379:6379   --name redis -v /data/redis/data:/data redis --appendonly yes

Write-Host "POSTGRES 服务创建中。。。。"
mkdir -p /data/postgres
docker run -d  --restart always --name postgres -p 5432:5432  -e POSTGRES_PASSWORD=123456 -v /data/postgres:/var/lib/postgresql/data  postgres
Write-Host "POSTGRES 服务创建完成"

Write-Host "RabbitMQ 创建中。。。"
mkdir -p /data/rabbitmq
docker run -d  --restart always  -v /data/rabbitmq:/var/lib/rabbitmq --name rabbitmq -p 5672:5672  -p 5671:5671 -p 15672:15672  -p 25672:25672   -p 4369:4369 rabbitmq
Write-Host "RabbitMQ 创建完成"
Write-Host "RabbitMQ 开启管理界面。。。。"
docker exec -it rabbitmq /bin/bash -c "rabbitmq-plugins enable rabbitmq_management"
Write-Host "RabbitMQ 开启管理界面完成"

Write-Host "Consul 服务创建中。。。。"
mkdir -p /data/consul
docker run -d  --restart always  -p 8500:8500 -e CONSUL_BIND_INTERFACE='eth0' --name consul consul agent -server -bootstrap -ui -client='0.0.0.0'
Write-Host "Consul 服务创建完成"

Write-Host "Nginx 服务创建中。。。。"
mkdir -p /data/nginx
docker run -d --name nginx nginx
docker cp nginx:/etc/nginx/ /data/nginx/
docker cp nginx:/usr/share/nginx/html/ /data/nginx/
docker stop nginx
docker rm nginx
docker run --restart always -d --name nginx -p 80:80 -p 443:443 -v /data/nginx/nginx/:/etc/nginx -v /data/nginx/html/:/usr/share/nginx/html nginx
Write-Host "Nginx 服务创建完成"

docker run -d  --restart always  -p 5433:80  -e "PGADMIN_DEFAULT_EMAIL=xuin23@outlook.com"  -e "PGADMIN_DEFAULT_PASSWORD=123456" --name pgadmin4 dpage/pgadmin4
