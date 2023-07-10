package com.phd.kafka.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class KafkaSenderWithMessageConverter {

	private final Logger logger = LoggerFactory.getLogger(KafkaSenderWithMessageConverter.class);

	@Autowired
	private KafkaTemplate<String, ?> kafkaTemplate;

	void sendMessageWithConverter(Message<?> user) {
		logger.info("Sending With Message Converter : {}", user);
		logger.info("--------------------------------");

		kafkaTemplate.send(user);
	}

}