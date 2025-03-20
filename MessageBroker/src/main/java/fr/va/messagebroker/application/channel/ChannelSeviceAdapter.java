package fr.va.messagebroker.application.channel;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.va.messagebroker.domain.channel.Channel;
import fr.va.messagebroker.domain.channel.ChannelServiceProxy;
import fr.va.messagebroker.infrastructure.channel.ChannelMapper;
import fr.va.messagebroker.infrastructure.channel.outbound.ChannelRepository;

@Service
public class ChannelSeviceAdapter implements ChannelServiceProxy {

	private ChannelRepository channelRepository;

	private ChannelMapper channelMapper;

	public ChannelSeviceAdapter(ChannelRepository channelRepository, ChannelMapper channelMapper) {
		this.channelRepository = channelRepository;
		this.channelMapper = channelMapper;
	}

	@Override
	public List<Channel> findAllChannels() {
		return channelMapper.ChannelRepositoryDTOListToChannelList(channelRepository.findAll());
	}

}
