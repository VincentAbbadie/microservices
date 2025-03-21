package fr.va.messagebroker.application.producer;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.va.messagebroker.domain.producer.Producer;
import fr.va.messagebroker.domain.producer.ProducerServiceProxy;
import fr.va.messagebroker.infrastructure.producer.ProducerMapper;
import fr.va.messagebroker.infrastructure.producer.outbound.ProducerRepository;

@Service
public class ProducerServiceAdapter implements ProducerServiceProxy {

	private ProducerRepository producerRepository;

	private ProducerMapper producerMapper;

	public ProducerServiceAdapter(ProducerRepository producerRepository, ProducerMapper producerMapper) {
		this.producerRepository = producerRepository;
		this.producerMapper = producerMapper;
	}

	@Override
	public List<Producer> findAllProducers() {
		return producerMapper.ProducerRepositoryDTOListToProducerList(producerRepository.findAll());
	}

}
