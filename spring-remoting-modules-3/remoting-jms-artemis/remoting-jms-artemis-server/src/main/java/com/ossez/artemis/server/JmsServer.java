package com.ossez.artemis.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.JmsListener;
//import org.springframework.jmsremoting.JmsInvokerServiceExporter;

@SpringBootApplication
public class JmsServer {

    /*
    This server needs to be connected to an ActiveMQ server.
    To quickly spin up an ActiveMQ server, you can use Docker.

    docker run -p 61616:61616 -p 8161:8161 rmohr/activemq:5.14.3
     */



    @JmsListener(destination = "remotingQueue")
    public void receive(String message) {
        System.out.println("Received message: " + message);
    }

    public static void main(String[] args) {
        SpringApplication.run(JmsServer.class, args);
    }

}
