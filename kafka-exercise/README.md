# Kafka exercise

1. Run kafka cluster locally via the confluent cli (see `run.sh`)
2. Create topic `test` with more than 5 partitions
3. Write a small java application that infinitely produce JSON messages to the topic `test`
   1. think about a partition key
   2. https://kafka.apache.org/36/javadoc/org/apache/kafka/clients/producer/KafkaProducer.html
4. Create a second java application and consume messages from the topic `test` and print them to the console
   5. https://kafka.apache.org/36/javadoc/org/apache/kafka/clients/consumer/KafkaConsumer.html
5. Disable auto-commit and tweak the offset commit to commit every 100 messages consumed
6. Start multiple consumers and create a consumer group
   1. For each consumer, print the partitions it's subscribed to
7. Kill consumer and see how the rebalancing works
   1. Are messages processed twice?