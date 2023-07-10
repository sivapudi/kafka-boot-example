package com.phd.kafka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phd.kafka.config.KafkaSenderWithMessageConverter;
import com.phd.kafka.example.KafkaSenderExample;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private KafkaSenderExample kafkaSenderExample;

	@Autowired
	private KafkaSenderWithMessageConverter messageConverterSender;

	@GetMapping("/publishMsg")
	public ResponseEntity<String> publish(@RequestParam("message") String message) {
		logger.info("message recived ::{}",message);
		kafkaSenderExample.sendMessage("I'll be recevied by MultipleTopicListener, Listener & ClassLevel KafkaHandler",
				message);
		return ResponseEntity.ok("message sent");
	}
}
