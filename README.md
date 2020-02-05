# Prerequisite
* Java 8
* Docker
* RabbitMq listening on its default port

# How to run
* Start publisher with `./gradlew publisher:bootRun -Dcmd`
* Start subscriber with `./gradlew subscriber:bootRun -Dcmd`
* Call exposed endpoint of publisher via curl as 
* `curl http://localhost:8080/order -d '{"orderId":"adfafdafafdasfas","products":[{"name":"abc","price":1010},{"name":"abc1","price":10101}],"receipient":{"basicProfile":{"name":"","phoneNumber":"","email":""},"addresses":[{"addressType":"billing","line1":"","line2":"","city":"","state":"","country":""},{"addressType":"delivery","line1":"","line2":"","city":"","state":"","country":""}]}}' -H "Content-Type: application/json"
`