package com.bsr.rabbitmqbasics.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class JobListener implements MessageListener{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void onMessage(Message message) {
		logger.info("received message {}",new String(message.getBody()));
	}
	
}