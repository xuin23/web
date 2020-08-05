Write-Host "Redis 服务创建中。。。。。"
mkdir -p /data/redis
docker run -p 6379:6379 --name redis -v /data/redis/redis.conf:/etc/redis/redis.conf -v /data/redis/data:/data -d redis redis-server /etc/redis/redis.conf --appendonly yes

Write-Host "POSTGRES 服务创建中。。。。"
mkdir -p /data/postgres
docker run -d  --name postgres -p 5432:5432   -e POSTGRES_PASSWORD=123456 -v /data/postgres:/var/lib/postgresql/data  postgres
Write-Host "POSTGRES 服务创建完成"

mkdir -p /data/rabbitmq
docker run -d -v /data/rabbitmq:/var/lib/rabbitmq --name rabbitmq -p 5672:5672  -p 5671:5671 -p 15672:15672  -p 25672:25672   -p 4369:4369 rabbitmq
Write-Host "RabbitMQ 创建完成"
Write-Host "RabbitMQ 开启管理界面。。。。"
docker exec -it rabbitmq /bin/bash -c "rabbitmq-plugins enable rabbitmq_management"
Write-Host "RabbitMQ 开启管理界面完成"

Write-Host "Consul 服务创建中。。。。"
mkdir -p /data/consul
docker run -d -p 8500:8500 -v /data/consul:/consul/data -e CONSUL_BIND_INTERFACE='eth0' --name=consul consul agent -server -bootstrap -ui -client='0.0.0.0'
Write-Host "Consul 服务创建完成"

