package fr.va.messagebroker.infrastructure.channel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import fr.va.messagebroker.domain.channel.Channel;
import fr.va.messagebroker.infrastructure.channel.inbound.ChannelResourceDTO;
import fr.va.messagebroker.infrastructure.channel.outbound.ChannelRepositoryDTO;
import fr.va.messagebroker.infrastructure.consumer.ConsumerMapper;
import fr.va.messagebroker.infrastructure.producer.ProducerMapper;

@Service
public class ChannelMapper {

	private ProducerMapper producerMapper;

	private ConsumerMapper consumerMapper;

	@Autowired
	public void setProducerMapper(@Lazy ProducerMapper producerMapper, @Lazy ConsumerMapper consumerMapper) {
		this.producerMapper = producerMapper;
		this.consumerMapper = consumerMapper;
	}

	public ChannelResourceDTO ChannelToChannelResourceDTO(Channel c) {
		final ChannelResourceDTO cDTO = new ChannelResourceDTO();

		cDTO.setId(c.getId());
		cDTO.setName(c.getName());
		cDTO.setProducers_id(c.getProducers().stream().map(p -> p.getId()).collect(Collectors.toSet()));
		cDTO.setConsumer_id(c.getConsumer().getId());

		return cDTO;
	}

	public Iterable<ChannelResourceDTO> ChannelListToChannelResourceDTOList(Iterable<Channel> cList) {
		final List<ChannelResourceDTO> cDTOList = new ArrayList<ChannelResourceDTO>();

		cList.forEach(c -> cDTOList.add(ChannelToChannelResourceDTO(c)));

		return cDTOList;
	}

	public Channel ChannelRepositoryDTOToChannel(ChannelRepositoryDTO cDTO) {
		final Channel c = new Channel();

		c.setId(cDTO.getId());
		c.setName(cDTO.getName());

		return c;
	}

	public Channel AddProducersToChannelFromChannelRepositoryDTO(Channel c, ChannelRepositoryDTO cDTO) {
		c.setProducers(producerMapper.ProducerRepositoryDTOListToProducerListWithoutChannels(cDTO.getProducers()));
		return c;
	}

	public Channel AddConsumerToChannelFromChannelRepositoryDTO(Channel c, ChannelRepositoryDTO cDTO) {
		c.setConsumer(consumerMapper.ConsumerRepositoryDTOToConsumer(cDTO.getConsumer()));
		return c;
	}

	public Set<Channel> ChannelRepositoryDTOListToChannelListWithProducersAndTheCconsumer(
			Iterable<ChannelRepositoryDTO> cDTOList) {
		final Set<Channel> cList = new HashSet<Channel>();

		cDTOList.forEach(cDTO -> {
			final Channel c = ChannelRepositoryDTOToChannel(cDTO);
			cList.add(AddProducersToChannelFromChannelRepositoryDTO(
					AddConsumerToChannelFromChannelRepositoryDTO(c, cDTO), cDTO));
		});

		return cList;
	}

	public Set<Channel> ChannelRepositoryDTOListToChannelListWithoutProducersNorConsumer(
			Iterable<ChannelRepositoryDTO> cDTOList) {
		final Set<Channel> cList = new HashSet<Channel>();

		cDTOList.forEach(c -> cList.add(ChannelRepositoryDTOToChannel(c)));

		return cList;
	}
}
