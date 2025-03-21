package fr.va.messagebroker.infrastructure.channel.inbound;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.va.messagebroker.domain.channel.ChannelService;
import fr.va.messagebroker.infrastructure.channel.ChannelMapper;

@RestController
@RequestMapping("/channels")
public class ChannelController {

	private ChannelService orderService;

	private ChannelMapper channelMapper;

	public ChannelController(ChannelService orderService, ChannelMapper channelMapper) {
		this.orderService = orderService;
		this.channelMapper = channelMapper;
	}

	@GetMapping()
	public List<ChannelResourceDTO> getAllChannels() {
		return channelMapper.ChannelListToChannelResourceDTOList(orderService.findAllChannels());
	}
}
