# Prerequisite
* Java 8
* Docker
* RabbitMq listening on its default port

# How to run
* To run tests ` ./gradlew publisher:test -Dcmd`.
* Start publisher with `./gradlew publisher:bootRun -Dcmd`. It will start server on port 8080.
* Start subscriber with `./gradlew subscriber:bootRun -Dcmd`. It will start server on port 9090.
* Call exposed endpoint of publisher via curl as 
* `curl http://localhost:8080/order -d '{"orderId":"adfafdafafdasfas","products":[{"name":"abc","price":1010},{"name":"abc1","price":10101}],"receipient":{"basicProfile":{"name":"","phoneNumber":"","email":""},"addresses":[{"addressType":"billing","line1":"","line2":"","city":"","state":"","country":""},{"addressType":"delivery","line1":"","line2":"","city":"","state":"","country":""}]}}' -H "Content-Type: application/json"
`
* You should see log entries on subscriber server console saying 4 msgs received.
* 1 message from topic exchange, 3 messages from fanout exchange as we have 3 subscribers for this exchange

# How to run (Dockerized)
* Run `docker-compose up -d` - this will start rabbitmq, publisher and subscribers
* Call exposed endpoint of publisher via curl as 
* `curl http://localhost:8080/order -d '{"orderId":"adfafdafafdasfas","products":[{"name":"abc","price":1010},{"name":"abc1","price":10101}],"receipient":{"basicProfile":{"name":"","phoneNumber":"","email":""},"addresses":[{"addressType":"billing","line1":"","line2":"","city":"","state":"","country":""},{"addressType":"delivery","line1":"","line2":"","city":"","state":"","country":""}]}}' -H "Content-Type: application/json"
`
* You should see log entries on subscriber server console saying 4 msgs received.
* 1 message from topic exchange, 3 messages from fanout exchange as we have 3 subscribers for this exchange