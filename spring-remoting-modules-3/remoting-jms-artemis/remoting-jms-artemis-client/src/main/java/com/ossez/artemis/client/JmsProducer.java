package com.ossez.artemis.client;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * JmsProducer
 * @author YuCheng Hu
 */
@Component
public class JmsProducer {

    private final JmsTemplate jmsTemplate;

    public JmsProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send(String message) {
        jmsTemplate.convertAndSend("remotingQueue", message);
    }

}
