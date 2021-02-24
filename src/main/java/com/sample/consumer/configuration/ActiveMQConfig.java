package com.sample.consumer.configuration;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
// Enable JMS
@EnableJms
public class ActiveMQConfig {
	
	// get broker configuration from application.properties
	@Value("${spring.activemq.broker-url}")
	String brokerUrl;
	
	// topics definition, same as Producer
	public static final String SENSOR_TOPIC = "sensor-topic";

	public static final String ORDER_TOPIC = "order-topic";

	// Serialize message content to json using TextMessage, same as Producer
	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}
	
	// client ActiveMQ connection factory. not needed credentials
	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(brokerUrl);
        return connectionFactory;
	}
	
	// JMS template configuration with connection factory and pub/sub enabled
	@Bean
	public JmsTemplate jmsTemplate(){
	    JmsTemplate template = new JmsTemplate();
	    template.setConnectionFactory(connectionFactory());
	    template.setMessageConverter(jacksonJmsMessageConverter());
	    template.setPubSubDomain(true);
	    return template;
	}
	

}
