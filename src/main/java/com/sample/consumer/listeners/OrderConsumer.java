package com.sample.consumer.listeners;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.sample.data.Order;

import static com.sample.consumer.configuration.ActiveMQConfig.ORDER_TOPIC;

import javax.jms.Session;

@Component
public class OrderConsumer {
	
	//jms listener on ORDER_TOPIC
    @JmsListener(destination = ORDER_TOPIC)
    public void receiveTopicMessage(@Payload Order order,
                                    @Headers MessageHeaders headers,
                                    Message message,
                                    Session session) {

        System.out.println("received order <" + order + ">");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("######          Message Details           #####");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("headers: " + headers);
        System.out.println("message: " + message);
        System.out.println("session: " + session);
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
    }
}
