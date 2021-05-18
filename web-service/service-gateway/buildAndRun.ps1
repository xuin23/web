docker build -f ./src/main/docker/Dockerfile  -t service/gateway .

docker run -d -p 8080:8080 service/gateway