# Prerequisite
* Java 8
* Docker

# How to run test
* Run `./gradlew test` from base directory

# What this repo is about
* It contains example as to how you can write integration tests for rabbitMq messages
* Its achieved by using testcontainers and registering rabbit listener to spring test context
* To send a message to rabbitMq, an API is provided
* How `OrderControllerIntegrationTest` works?
  * Its extending `AbstractIntegrationTest`. This parent class is responsible for providing spring test context.
  * It also starts `RabbitMQContainer` and maps container IP and exposed host port at runtime to spring config. Check `AbstractIntegrationTest#Initializer` class for more details.
  * Once spring test context is loaded, as API is hit using `testRestTemplate`, this API will publish an `OrderDto` object to rabbitMq.
  * This message will be listened by `RabbitMqTestReceiver` as configured in `RabbitMqTestConfig`.
  * Once a message is received by `RabbitMqTestReceiver` it will be added to its internal blocking queue.
  * In another thread (on which the test is running), will be calling `RabbitMqTestReceiver#XXXXgetOrderOrWait`. This call is a blocking call that means, unless a message is available in blocking queue, call won't return.
  * Once a call is returned, it would have received the `OrderDto` object which then used for assertion in the test.
  * Example covers sending and receving message to **topic exchange** and **fanout exchange**.
