package fr.va.messagebroker.infrastructure.producer.inbound;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.va.messagebroker.domain.producer.ProducerService;
import fr.va.messagebroker.infrastructure.NotFoundException;
import fr.va.messagebroker.infrastructure.producer.ProducerMapper;

@RestController
@RequestMapping("/producers")
public class ProducerController {

	private ProducerService producerService;

	private ProducerMapper producerMapper;

	public ProducerController(ProducerService producerSerivce, ProducerMapper producerMapper) {
		this.producerService = producerSerivce;
		this.producerMapper = producerMapper;
	}

	@GetMapping()
	public Iterable<ProducerResourceDTO> getAllProducers() {
		return producerMapper.ProducerListToProducerResourceDTOList(producerService.findAllProducer());
	}

	@GetMapping("/{id}")
	public ProducerResourceDTO getProducer(@PathVariable String id) {
		final UUID producerId = UUID.fromString(id);
		final ProducerResourceDTO pDTO = producerMapper
				.ProducerToProducerResourceDTO(producerService.findProducer(producerId));
		if (pDTO == null)
			throw new NotFoundException(new NullPointerException("Producer " + producerId + " is null"));
		return pDTO;
	}
}
