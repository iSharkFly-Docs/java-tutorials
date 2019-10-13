package com.ossez.springamqp.simple;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YuCheng Hu
 */
@SpringBootApplication
public class AMQPHelloWorldMessageApp {

    private static final boolean NON_DURABLE = true;
    private static final String MY_QUEUE_NAME = "com.ossez.real.estate";
    private static final String MY_QUEUE_HOSTMANME = "mq.ossez.com";
    private static final String MY_QUEUE_USERNAME = "username";
    private static final String MY_QUEUE_PASSWORD = "password";

    public static void main(String[] args) {

        SpringApplication.run(AMQPHelloWorldMessageApp.class, args);
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(MY_QUEUE_HOSTMANME);
        connectionFactory.setUsername(MY_QUEUE_USERNAME);
        connectionFactory.setPassword(MY_QUEUE_PASSWORD);

        return connectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {

        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        //The routing key is set to the name of the queue by the broker for the default exchange.


        template.setRoutingKey(MY_QUEUE_NAME);

        //Where we will synchronously receive messages from
        template.setDefaultReceiveQueue(MY_QUEUE_NAME);
        return template;
    }

    @Bean
    Queue myQueue() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-queue-type", "classic");

        return new Queue(MY_QUEUE_NAME, NON_DURABLE, false, false, args);
    }


    @Bean
    public ApplicationRunner runner(RabbitTemplate template) {
        return args -> {
            for (int i = 0; i < 1000; i++) {
                template.convertAndSend("Hello, world - OSSEZ.COM! >> " + i);
            }

        };
    }


    @RabbitListener(queues = MY_QUEUE_NAME)
    public void listen(String in) {
        System.out.println("Message read from myQueue : " + in);
    }

}
