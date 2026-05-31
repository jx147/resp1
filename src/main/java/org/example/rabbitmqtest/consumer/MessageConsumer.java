package org.example.rabbitmqtest.consumer;

import org.example.rabbitmqtest.config.RabbitMQConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    private static final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveMessage(String message) {
        logger.info("收到消息: {}", message);
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveObjectMessage(Object object) {
        logger.info("收到对象消息: {}", object);
    }
}
