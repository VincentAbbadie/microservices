package fr.va.messagebroker.infrastructure.consumer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.va.messagebroker.domain.consumer.Consumer;
import fr.va.messagebroker.infrastructure.consumer.inbound.ConsumerResourceDTO;
import fr.va.messagebroker.infrastructure.consumer.outbound.ConsumerRepositoryDTO;

@Service
public class ConsumerMapper {

	private Consumer ConsumerRepositoryDTOToConsumer(ConsumerRepositoryDTO cDTO) {
		final Consumer c = new Consumer();

		c.setId(cDTO.getId());
		c.setName(cDTO.getName());

		return c;
	}

	public List<Consumer> ConsumerRepositoryDTOListToConsumerList(Iterable<ConsumerRepositoryDTO> cDTOList) {
		final List<Consumer> cList = new ArrayList<Consumer>();

		cDTOList.forEach(c -> cList.add(ConsumerRepositoryDTOToConsumer(c)));

		return cList;
	}

	private ConsumerResourceDTO ConsumerToConsumerResourceDTO(Consumer c) {
		final ConsumerResourceDTO cDTO = new ConsumerResourceDTO();

		cDTO.setId(c.getId());
		cDTO.setName(c.getName());

		return cDTO;
	}

	public List<ConsumerResourceDTO> ConsumerListToConsumerResourceDTOList(Iterable<Consumer> cList) {
		final List<ConsumerResourceDTO> cDTOList = new ArrayList<ConsumerResourceDTO>();

		cList.forEach(c -> cDTOList.add(ConsumerToConsumerResourceDTO(c)));

		return cDTOList;
	}

}
