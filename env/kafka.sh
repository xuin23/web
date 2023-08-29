docker network create kafka-net

docker run -d --name kafka --network=kafka-net -p 9092:9092 -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://kafka:9092 confluentinc/cp-kafka
