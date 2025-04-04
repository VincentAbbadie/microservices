package fr.va.messagebroker.infrastructure.consumer.inbound;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.va.messagebroker.domain.consumer.ConsumerService;
import fr.va.messagebroker.infrastructure.NotFoundException;
import fr.va.messagebroker.infrastructure.consumer.ConsumerMapper;

@RestController
@RequestMapping("/consumers")
public class ConsumerController {

	private ConsumerService consumerService;

	private ConsumerMapper consumerMapper;

	public ConsumerController(ConsumerService consumerService, ConsumerMapper consumerMapper) {
		this.consumerService = consumerService;
		this.consumerMapper = consumerMapper;
	}

	@GetMapping
	public List<ConsumerResourceDTO> getAllConsumers() {
		return consumerMapper.ConsumerListToConsumerResourceDTOList(consumerService.findAllConsumers());
	}

	@GetMapping("/{id}")
	public ConsumerResourceDTO getConsumer(@PathVariable String id) {
		final UUID consumerId = UUID.fromString(id);
		final ConsumerResourceDTO cDTO = consumerMapper
				.ConsumerToConsumerResourceDTO(consumerService.findConsumer(consumerId));
		if (cDTO == null)
			throw new NotFoundException(new NullPointerException("Consumer " + consumerId + " is null"));
		return cDTO;
	}
}
