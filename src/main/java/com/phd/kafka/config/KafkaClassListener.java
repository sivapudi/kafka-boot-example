package com.phd.kafka.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(id = "class-level", topics = "phd-1")
class KafkaClassListener {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@KafkaHandler
	void listen(String message) {
		logger.info("ClassLevel KafkaHandler[String] {}", message);
	}

	@KafkaHandler(isDefault = true)
	void listenDefault(Object object) {
		logger.info("ClassLevel KafkaHandler[Default] {}", object);
	}
}
