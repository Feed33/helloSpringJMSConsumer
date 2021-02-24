package com.sample.consumer.listeners;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.sample.data.Sensor;

import static com.sample.consumer.configuration.ActiveMQConfig.SENSOR_TOPIC;

import javax.jms.Session;

@Component
public class SensorConsumer {
	
	// JMS listener on SENSOR_TOPIC
    @JmsListener(destination = SENSOR_TOPIC)
    public void receiveTopicMessage(@Payload Sensor sensor,
                                    @Headers MessageHeaders headers,
                                    Message message,
                                    Session session) {

        System.out.println("received sensor data <" + sensor + ">");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("######          Message Details           #####");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("headers: " + headers);
        System.out.println("message: " + message);
        System.out.println("session: " + session);
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
    }
}
