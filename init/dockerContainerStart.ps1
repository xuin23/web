Write-Host "Redis 服务创建中。。。。。"
docker run -d -p 6379:6379 redis
Write-Host "RabbitMQ 服务创建中。。。。"
docker run -d -p 5672:5672 -p 15672:15672 rabbitmq