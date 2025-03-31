package fr.va.messagebroker.application.consumer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import fr.va.messagebroker.domain.consumer.Consumer;
import fr.va.messagebroker.domain.consumer.ConsumerServiceProxy;
import fr.va.messagebroker.infrastructure.consumer.ConsumerMapper;
import fr.va.messagebroker.infrastructure.consumer.outbound.ConsumerRepository;
import fr.va.messagebroker.infrastructure.consumer.outbound.ConsumerRepositoryDTO;

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

	@Override
	public Consumer findConsumer(UUID consumerId) {
		final Optional<ConsumerRepositoryDTO> cDTO = consumerRepository.findById(consumerId);
		return cDTO.isPresent() ? consumerMapper.ConsumerRepositoryDTOToConsumer(cDTO.get()) : null;
	}

}
