package fr.va.messagebroker.infrastructure.producer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.va.messagebroker.domain.producer.Producer;
import fr.va.messagebroker.infrastructure.producer.inbound.ProducerResourceDTO;
import fr.va.messagebroker.infrastructure.producer.outbound.ProducerRepositoryDTO;

@Service
public class ProducerMapper {

	private ProducerResourceDTO ProducerToProducerResourceDTO(Producer p) {
		final ProducerResourceDTO pDTO = new ProducerResourceDTO();

		pDTO.setId(p.getId());
		pDTO.setName(p.getName());

		return pDTO;
	}

	public List<ProducerResourceDTO> ProducerListToProducerResourceDTOList(Iterable<Producer> pList) {
		final List<ProducerResourceDTO> pDTOList = new ArrayList<ProducerResourceDTO>();

		pList.forEach(p -> pDTOList.add(ProducerToProducerResourceDTO(p)));

		return pDTOList;
	}

	private Producer ProducerRepositoryDTOToProducer(ProducerRepositoryDTO pDTO) {
		final Producer p = new Producer();

		p.setId(pDTO.getId());
		p.setName(pDTO.getName());

		return p;
	}

	public List<Producer> ProducerRepositoryDTOListToProducerList(Iterable<ProducerRepositoryDTO> pDTOList) {
		final List<Producer> pList = new ArrayList<Producer>();

		pDTOList.forEach(p -> pList.add(ProducerRepositoryDTOToProducer(p)));

		return pList;
	}

}
