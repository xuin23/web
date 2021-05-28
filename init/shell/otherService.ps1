Write-Host "Docker 远程Web服务创建中。。。。。"
docker run -d  --restart always  --name docker-web -p 9000:9000 -v /var/run/docker.sock:/var/run/docker.sock uifd/ui-for-docker
Write-Host "PGAdmin4 服务创建中。。。。"
docker run -d  --restart always  -p 5433:80  -e "PGADMIN_DEFAULT_EMAIL=xuin23@outlook.com"  -e "PGADMIN_DEFAULT_PASSWORD=123456" --name pgadmin4 dpage/pgadmin4