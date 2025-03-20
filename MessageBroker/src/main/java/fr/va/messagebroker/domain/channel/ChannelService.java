package fr.va.messagebroker.domain.channel;

import java.util.List;

public class ChannelService {

	private ChannelServiceProxy channelServiceProxy;

	public ChannelService(ChannelServiceProxy channelServiceProxy) {
		this.channelServiceProxy = channelServiceProxy;
	}

	public String sayHello() {
		return "sayHeello";
	}

	public List<Channel> findAllChannels() {
		return channelServiceProxy.findAllChannels();
	}

}
