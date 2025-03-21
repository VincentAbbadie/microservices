package fr.va.messagebroker.application.consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.va.messagebroker.domain.consumer.ConsumerService;
import fr.va.messagebroker.domain.consumer.ConsumerServiceProxy;

@Configuration
public class ConsumerConfiguration {

	@Bean
	public ConsumerService consumerService(ConsumerServiceProxy consumerServiceProxy) {
		return new ConsumerService(consumerServiceProxy);
	}

}
