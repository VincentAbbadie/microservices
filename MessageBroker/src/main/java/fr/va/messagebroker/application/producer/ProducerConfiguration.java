package fr.va.messagebroker.application.producer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.va.messagebroker.domain.producer.ProducerService;
import fr.va.messagebroker.domain.producer.ProducerServiceProxy;

@Configuration
public class ProducerConfiguration {

	@Bean
	public ProducerService producerService(ProducerServiceProxy producerServiceProxy) {
		return new ProducerService(producerServiceProxy);
	}

}
