package fr.va.messagebroker.infrastructure.channel.inbound;

import java.util.Set;
import java.util.UUID;

public class ChannelResourceDTO {

	private UUID id;

	private String name;

	private Set<UUID> producers_id;

	private UUID consumer_id;

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

	public Set<UUID> getProducers_id() {
		return producers_id;
	}

	public void setProducers_id(Set<UUID> producers_id) {
		this.producers_id = producers_id;
	}

	public UUID getConsumer_id() {
		return consumer_id;
	}

	public void setConsumer_id(UUID consumer_id) {
		this.consumer_id = consumer_id;
	}

}
