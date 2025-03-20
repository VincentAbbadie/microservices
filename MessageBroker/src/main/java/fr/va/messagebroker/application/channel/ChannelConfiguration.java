package fr.va.messagebroker.application.channel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.va.messagebroker.domain.channel.ChannelService;
import fr.va.messagebroker.domain.channel.ChannelServiceProxy;

@Configuration
public class ChannelConfiguration {

	@Bean
	public ChannelService channelService(ChannelServiceProxy channelServiceProxy) {
		return new ChannelService(channelServiceProxy);
	}

}
