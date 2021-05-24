docker stop auth-core1
docker stop auth-core2
docker stop auth-core3

docker rm auth-core1
docker rm auth-core2
docker rm auth-core3

docker build -f ./src/main/docker/Dockerfile -t auth-core .

docker run --name auth-core1 -d auth-core
docker run --name auth-core2 -d auth-core
docker run --name auth-core3 -d auth-core