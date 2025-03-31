package fr.va.messagebroker.domain.channel;

import java.util.UUID;

public class ChannelService {

	private ChannelServiceProxy channelServiceProxy;

	public ChannelService(ChannelServiceProxy channelServiceProxy) {
		this.channelServiceProxy = channelServiceProxy;
	}

	public Iterable<Channel> findAllChannels() {
		return channelServiceProxy.findAllChannels();
	}

	public Channel findChannel(UUID channelId) {
		return channelServiceProxy.findChannel(channelId);
	}

}
