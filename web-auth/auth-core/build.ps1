docker build -f ./src/main/docker/Dockerfile -t auth-core .

docker run -d auth-core