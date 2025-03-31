package fr.va.messagebroker.infrastructure.producer;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import fr.va.messagebroker.domain.producer.Producer;
import fr.va.messagebroker.infrastructure.channel.ChannelMapper;
import fr.va.messagebroker.infrastructure.producer.inbound.ProducerResourceDTO;
import fr.va.messagebroker.infrastructure.producer.outbound.ProducerRepositoryDTO;

@Service
public class ProducerMapper {

	private ChannelMapper channelMapper;

	@Autowired
	public void setChannelMapper(@Lazy ChannelMapper channelMapper) {
		this.channelMapper = channelMapper;
	}

	public ProducerResourceDTO ProducerToProducerResourceDTO(Producer p) {
		if (p == null)
			return null;

		final ProducerResourceDTO pDTO = new ProducerResourceDTO();

		pDTO.setId(p.getId());
		pDTO.setName(p.getName());
		pDTO.setChannels_id(p.getChannels().stream().map(c -> c.getId()).collect(Collectors.toSet()));

		return pDTO;
	}

	public Iterable<ProducerResourceDTO> ProducerListToProducerResourceDTOList(Iterable<Producer> pList) {
		final Set<ProducerResourceDTO> pDTOList = new HashSet<ProducerResourceDTO>();

		pList.forEach(p -> pDTOList.add(ProducerToProducerResourceDTO(p)));

		return pDTOList;
	}

	public Producer ProducerRepositoryDTOToProducer(ProducerRepositoryDTO pDTO) {
		final Producer p = new Producer();

		p.setId(pDTO.getId());
		p.setName(pDTO.getName());

		return p;
	}

	public Producer AddChannelsToProducerFromProducerRepositoryDTO(Producer p, ProducerRepositoryDTO pDTO) {
		p.setChannels(
				channelMapper.ChannelRepositoryDTOListToChannelListWithoutProducersNorConsumer(pDTO.getChannels()));
		return p;
	}

	public Set<Producer> ProducerRepositoryDTOListToProducerListWithChannels(Iterable<ProducerRepositoryDTO> pDTOList) {
		final Set<Producer> pList = new HashSet<Producer>();

		pDTOList.forEach(pDTO -> {
			final Producer p = ProducerRepositoryDTOToProducer(pDTO);
			pList.add(AddChannelsToProducerFromProducerRepositoryDTO(p, pDTO));
		});

		return pList;
	}

	public Set<Producer> ProducerRepositoryDTOListToProducerListWithoutChannels(
			Iterable<ProducerRepositoryDTO> pDTOList) {
		final Set<Producer> pList = new HashSet<Producer>();

		pDTOList.forEach(p -> pList.add(ProducerRepositoryDTOToProducer(p)));

		return pList;
	}
}
