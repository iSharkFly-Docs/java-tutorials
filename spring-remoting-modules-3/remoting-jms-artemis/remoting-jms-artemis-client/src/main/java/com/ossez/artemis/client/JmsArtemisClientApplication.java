package com.ossez.artemis.client;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JmsArtemisClientApplication {

    public static void main(String[] args) {
        JmsProducer jmsProducer = SpringApplication.run(JmsArtemisClientApplication.class, args).getBean(JmsProducer.class);
        jmsProducer.send("xxxddx");;

    }

}
