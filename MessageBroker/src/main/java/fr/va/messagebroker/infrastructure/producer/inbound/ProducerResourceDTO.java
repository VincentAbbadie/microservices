package fr.va.messagebroker.infrastructure.producer.inbound;

import java.util.Set;
import java.util.UUID;

public class ProducerResourceDTO {

	private UUID id;

	private String name;

	private Set<UUID> channels_id;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<UUID> getChannels_id() {
		return channels_id;
	}

	public void setChannels_id(Set<UUID> channel_id) {
		this.channels_id = channel_id;
	}

}
