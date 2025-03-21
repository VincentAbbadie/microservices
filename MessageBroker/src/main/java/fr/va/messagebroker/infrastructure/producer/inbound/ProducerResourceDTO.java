package fr.va.messagebroker.infrastructure.producer.inbound;

import java.util.UUID;

public class ProducerResourceDTO {

	private UUID id;

	private String name;

	private UUID channel_id;

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

	public UUID getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(UUID channel_id) {
		this.channel_id = channel_id;
	}

}
