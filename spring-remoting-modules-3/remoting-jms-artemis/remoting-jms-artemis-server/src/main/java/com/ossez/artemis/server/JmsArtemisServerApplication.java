package com.ossez.artemis.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.JmsListener;

/**
 * JMS Message Consumer Application
 *
 * @author YuCheng Hu
 */
@SpringBootApplication
public class JmsArtemisServerApplication {


    @JmsListener(destination = "remotingQueue")
    public void receive(String message) {
        System.out.println("Received message: " + message);
    }

    public static void main(String[] args) {
        SpringApplication.run(JmsArtemisServerApplication.class, args);
    }

}
