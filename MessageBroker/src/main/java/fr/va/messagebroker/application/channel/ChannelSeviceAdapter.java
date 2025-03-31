package fr.va.messagebroker.application.channel;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import fr.va.messagebroker.domain.channel.Channel;
import fr.va.messagebroker.domain.channel.ChannelServiceProxy;
import fr.va.messagebroker.infrastructure.channel.ChannelMapper;
import fr.va.messagebroker.infrastructure.channel.outbound.ChannelRepository;
import fr.va.messagebroker.infrastructure.channel.outbound.ChannelRepositoryDTO;

@Service
public class ChannelSeviceAdapter implements ChannelServiceProxy {

	private ChannelRepository channelRepository;

	private ChannelMapper channelMapper;

	public ChannelSeviceAdapter(ChannelRepository channelRepository, ChannelMapper channelMapper) {
		this.channelRepository = channelRepository;
		this.channelMapper = channelMapper;
	}

	@Override
	public Iterable<Channel> findAllChannels() {
		return channelMapper
				.ChannelRepositoryDTOListToChannelListWithProducersAndTheCconsumer(channelRepository.findAll());
	}

	@Override
	public Channel findChannel(UUID channelId) {
		final Optional<ChannelRepositoryDTO> cDTO = channelRepository.findById(channelId);
		return cDTO.isPresent()
				? channelMapper
						.AddProducersToChannelFromChannelRepositoryDTO(
								channelMapper.AddConsumerToChannelFromChannelRepositoryDTO(
										channelMapper.ChannelRepositoryDTOToChannel(cDTO.get()), cDTO.get()),
								cDTO.get())
				: null;
	}

}
