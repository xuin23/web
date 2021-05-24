docker stop message-core1
docker stop message-core2
docker stop message-core3

docker rm message-core1
docker rm message-core2
docker rm message-core3

docker build -f ./src/main/docker/Dockerfile -t message-core .

docker run --name message-core1 -d message-core
docker run --name message-core2 -d message-core
docker run --name message-core3 -d message-core