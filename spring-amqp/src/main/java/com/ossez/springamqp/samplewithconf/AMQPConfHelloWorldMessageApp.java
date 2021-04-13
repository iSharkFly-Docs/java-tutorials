package com.ossez.springamqp.samplewithconf;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YuCheng Hu
 */
@SpringBootApplication
public class AMQPConfHelloWorldMessageApp {


    public static void main(String[] args) {
        SpringApplication.run(AMQPConfHelloWorldMessageApp.class, args);
    }


    @Bean
    public ApplicationRunner runner(RabbitTemplate rabbitTemplate) {
        return args -> {
            for (int i = 0; i < 10000; i++) {
                rabbitTemplate.convertAndSend("Hello, world - OSSEZ.COM + CONF! - " + i);
            }
        };
    }


    @RabbitListener(queues = AMQPConf.MY_QUEUE_NAME)
    public void listen(String in) {
        System.out.println("Message read from myQueue : " + in);
    }

}
