package fr.va.messagebroker.infrastructure.channel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.va.messagebroker.domain.channel.Channel;
import fr.va.messagebroker.infrastructure.channel.inbound.ChannelResourceDTO;
import fr.va.messagebroker.infrastructure.channel.outbound.ChannelRepositoryDTO;

@Service
public class ChannelMapper {

	private ChannelResourceDTO ChannelToChannelResourceDTO(Channel c) {
		final ChannelResourceDTO cDTO = new ChannelResourceDTO();

		cDTO.setId(c.getId());
		cDTO.setName(c.getName());

		return cDTO;
	}

	public List<ChannelResourceDTO> ChannelListToChannelResourceDTOList(Iterable<Channel> cList) {
		final List<ChannelResourceDTO> cDTOList = new ArrayList<ChannelResourceDTO>();

		cList.forEach(c -> cDTOList.add(ChannelToChannelResourceDTO(c)));

		return cDTOList;
	}

	private Channel ChannelRepositoryDTOToChannel(ChannelRepositoryDTO cDTO) {
		final Channel c = new Channel();

		c.setId(cDTO.getId());
		c.setName(cDTO.getName());

		return c;
	}

	public List<Channel> ChannelRepositoryDTOListToChannelList(Iterable<ChannelRepositoryDTO> cDTOList) {
		final List<Channel> cList = new ArrayList<Channel>();

		cDTOList.forEach(c -> cList.add(ChannelRepositoryDTOToChannel(c)));

		return cList;
	}
}
