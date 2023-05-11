docker stop service-gateway

docker rm service-gateway

docker rmi service-gateway

docker build -f ./src/main/docker/Dockerfile  -t service-gateway .

docker run -d -p 8080:8080 --name service-gateway service-gateway 