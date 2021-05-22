docker stop auth-core

docker rm auth-core

docker build -f ./src/main/docker/Dockerfile -t auth-core .

docker run --name auth-core -d auth-core