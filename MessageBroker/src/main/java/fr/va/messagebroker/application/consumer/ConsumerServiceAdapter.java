package fr.va.messagebroker.application.consumer;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.va.messagebroker.domain.consumer.Consumer;
import fr.va.messagebroker.domain.consumer.ConsumerServiceProxy;
import fr.va.messagebroker.infrastructure.consumer.ConsumerMapper;
import fr.va.messagebroker.infrastructure.consumer.outbound.ConsumerRepository;

@Service
public class ConsumerServiceAdapter implements ConsumerServiceProxy {

	private ConsumerRepository consumerRepository;

	private ConsumerMapper consumerMapper;

	public ConsumerServiceAdapter(ConsumerRepository consumerRepository, ConsumerMapper consumerMapper) {
		this.consumerRepository = consumerRepository;
		this.consumerMapper = consumerMapper;
	}

	@Override
	public List<Consumer> findAllConsumers() {
		return consumerMapper.ConsumerRepositoryDTOListToConsumerList(consumerRepository.findAll());
	}

}
