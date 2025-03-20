package fr.va.messagebroker.infrastructure.messages.outbound;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "messages")
public class MessageRepositoryDTO {

	@Id
	@Column(name = "ID")
	private UUID id;

	@Column(name = "CHANNELS_ID_FK")
	private UUID channel_id;

	@Column(name = "CONTENT")
	private String content;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(UUID channel_id) {
		this.channel_id = channel_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
