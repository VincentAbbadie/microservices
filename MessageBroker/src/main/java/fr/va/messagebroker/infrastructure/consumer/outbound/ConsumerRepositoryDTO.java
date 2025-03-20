package fr.va.messagebroker.infrastructure.consumer.outbound;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "consumers")
public class ConsumerRepositoryDTO {

	@Id
	@Column(name = "ID")
	private UUID id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "CHANNELS_ID_FK")
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
