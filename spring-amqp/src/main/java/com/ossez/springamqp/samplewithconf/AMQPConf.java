package com.ossez.springamqp.samplewithconf;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AMQPConf {
    public static final String MY_QUEUE_NAME = "com.ossez.real.estate";
    private static final String MY_QUEUE_HOSTMANME = "mq.ossez.com";
    private static final String MY_QUEUE_USERNAME = "username";
    private static final String MY_QUEUE_PASSWORD = "password";

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(MY_QUEUE_HOSTMANME);
        connectionFactory.setUsername(MY_QUEUE_USERNAME);
        connectionFactory.setPassword(MY_QUEUE_PASSWORD);

        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
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
    // Every queue is bound to the default direct exchange
    public Queue helloWorldQueue() {
        Map<String, Object> args = new HashMap<>();
        // set the queue with a dead letter feature
        args.put("x-queue-type", "classic");
        Queue queue = new Queue(MY_QUEUE_NAME, true, false, false, args);

//        Queue queue = new Queue(this.helloWorldQueueName);

        return queue;
    }

	/*
	@Bean
	public Binding binding() {
		return declare(new Binding(helloWorldQueue(), defaultDirectExchange()));
	}*/

	/*
	@Bean
	public TopicExchange helloExchange() {
		return declare(new TopicExchange("hello.world.exchange"));
	}*/

	/*
	public Queue declareUniqueQueue(String namePrefix) {
		Queue queue = new Queue(namePrefix + "-" + UUID.randomUUID());
		rabbitAdminTemplate().declareQueue(queue);
		return queue;
	}
	// if the default exchange isn't configured to your liking....
	@Bean Binding declareP2PBinding(Queue queue, DirectExchange exchange) {
		return declare(new Binding(queue, exchange, queue.getName()));
	}
	@Bean Binding declarePubSubBinding(String queuePrefix, FanoutExchange exchange) {
		return declare(new Binding(declareUniqueQueue(queuePrefix), exchange));
	}
	@Bean Binding declarePubSubBinding(UniqueQueue uniqueQueue, TopicExchange exchange) {
		return declare(new Binding(uniqueQueue, exchange));
	}
	@Bean Binding declarePubSubBinding(String queuePrefix, TopicExchange exchange, String routingKey) {
		return declare(new Binding(declareUniqueQueue(queuePrefix), exchange, routingKey));
	}*/

}
