package fr.va.messagebroker.domain.channel;

import java.util.UUID;

public interface ChannelServiceProxy {

	public Iterable<Channel> findAllChannels();

	public Channel findChannel(UUID channelId);
}
