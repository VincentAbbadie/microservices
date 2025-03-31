package fr.va.messagebroker.infrastructure.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import fr.va.messagebroker.domain.consumer.Consumer;
import fr.va.messagebroker.infrastructure.channel.ChannelMapper;
import fr.va.messagebroker.infrastructure.consumer.inbound.ConsumerResourceDTO;
import fr.va.messagebroker.infrastructure.consumer.outbound.ConsumerRepositoryDTO;

@Service
public class ConsumerMapper {

	private ChannelMapper channelMapper;

	@Autowired
	public void setConsumerMapper(@Lazy ChannelMapper channelMapper) {
		this.channelMapper = channelMapper;
	}

	public Consumer ConsumerRepositoryDTOToConsumer(ConsumerRepositoryDTO cDTO) {
		final Consumer c = new Consumer();

		c.setId(cDTO.getId());
		c.setName(cDTO.getName());
		c.setChannels(
				channelMapper.ChannelRepositoryDTOListToChannelListWithoutProducersNorConsumer(cDTO.getChannels()));

		return c;
	}

	public List<Consumer> ConsumerRepositoryDTOListToConsumerList(Iterable<ConsumerRepositoryDTO> cDTOList) {
		final List<Consumer> cList = new ArrayList<Consumer>();

		cDTOList.forEach(c -> cList.add(ConsumerRepositoryDTOToConsumer(c)));

		return cList;
	}

	public ConsumerResourceDTO ConsumerToConsumerResourceDTO(Consumer c) {
		final ConsumerResourceDTO cDTO = new ConsumerResourceDTO();

		cDTO.setId(c.getId());
		cDTO.setName(c.getName());
		cDTO.setChannels_id(c.getChannels().stream().map(ch -> ch.getId()).collect(Collectors.toSet()));

		return cDTO;
	}

	public List<ConsumerResourceDTO> ConsumerListToConsumerResourceDTOList(Iterable<Consumer> cList) {
		final List<ConsumerResourceDTO> cDTOList = new ArrayList<ConsumerResourceDTO>();

		cList.forEach(c -> cDTOList.add(ConsumerToConsumerResourceDTO(c)));

		return cDTOList;
	}

}
