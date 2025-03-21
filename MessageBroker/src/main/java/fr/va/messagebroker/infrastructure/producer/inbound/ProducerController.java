package fr.va.messagebroker.infrastructure.producer.inbound;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.va.messagebroker.domain.producer.ProducerService;
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
	public List<ProducerResourceDTO> getAllProducers() {
		return producerMapper.ProducerListToProducerResourceDTOList(producerService.findAllProducer());
	}
}
