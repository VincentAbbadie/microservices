package fr.va.messagebroker.application.producer;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import fr.va.messagebroker.domain.producer.Producer;
import fr.va.messagebroker.domain.producer.ProducerServiceProxy;
import fr.va.messagebroker.infrastructure.producer.ProducerMapper;
import fr.va.messagebroker.infrastructure.producer.outbound.ProducerRepository;
import fr.va.messagebroker.infrastructure.producer.outbound.ProducerRepositoryDTO;

@Service
public class ProducerServiceAdapter implements ProducerServiceProxy {

	private ProducerRepository producerRepository;

	private ProducerMapper producerMapper;

	public ProducerServiceAdapter(ProducerRepository producerRepository, ProducerMapper producerMapper) {
		this.producerRepository = producerRepository;
		this.producerMapper = producerMapper;
	}

	@Override
	public Iterable<Producer> findAllProducers() {
		return producerMapper.ProducerRepositoryDTOListToProducerListWithChannels(producerRepository.findAll());
	}

	@Override
	public Producer findProducer(UUID producerId) {
		final Optional<ProducerRepositoryDTO> pDTO = producerRepository.findById(producerId);
		return pDTO.isPresent() ? producerMapper.AddChannelsToProducerFromProducerRepositoryDTO(
				producerMapper.ProducerRepositoryDTOToProducer(pDTO.get()), pDTO.get()) : null;
	}
}
