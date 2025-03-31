package fr.va.messagebroker.infrastructure.channel.inbound;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.va.messagebroker.domain.channel.ChannelService;
import fr.va.messagebroker.infrastructure.NotFoundException;
import fr.va.messagebroker.infrastructure.channel.ChannelMapper;

@RestController
@RequestMapping("/channels")
public class ChannelController {

	private ChannelService channelService;

	private ChannelMapper channelMapper;

	public ChannelController(ChannelService channelService, ChannelMapper channelMapper) {
		this.channelService = channelService;
		this.channelMapper = channelMapper;
	}

	@GetMapping()
	public Iterable<ChannelResourceDTO> getAllChannels() {
		return channelMapper.ChannelListToChannelResourceDTOList(channelService.findAllChannels());
	}

	@GetMapping("/{id}")
	public ChannelResourceDTO getChannel(@PathVariable String id) {
		final UUID channelId = UUID.fromString(id);
		final ChannelResourceDTO cDTO = channelMapper
				.ChannelToChannelResourceDTO(channelService.findChannel(channelId));
		if (cDTO == null)
			throw new NotFoundException(new NullPointerException("Channel " + channelId + " is null"));
		return cDTO;
	}
}
