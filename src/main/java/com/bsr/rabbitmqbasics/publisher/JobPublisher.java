package com.bsr.rabbitmqbasics.publisher;

import java.util.Map;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bsr.rabbitmqbasics.entity.Job;

@Component
public class JobPublisher {
	
	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Value("${rabbitmq.routing-keys}")
	private String routingKey;
	@Value("${rabbitmq.exchange}")
	private String exchangeName;
	
	public Job publishJob(Map<String, Object> details) {
		Job newJob = new Job();
		newJob.setDetails(details);
		try {
			rabbitTemplate.convertAndSend(exchangeName,routingKey,newJob);
			newJob.setStatus("published");
		}
		catch(Exception e) {
			e.printStackTrace();
			newJob.setStatus("failed_to_publish");
		}
		return newJob;
	}
	
}