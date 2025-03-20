package fr.va.messagebroker.infrastructure.messagessent.outbound;

import java.time.LocalTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "messages_sent")
public class MessagesSentRepositoryDTO {

	@Id
	@Column(name = "ID")
	private UUID id;

	@Column(name = "CONSUMER_ID_FK")
	private UUID consumer_id;

	@Column(name = "MESSAGE_ID_FK")
	private UUID message_id;

	@Column(name = "DELIVERY_TIMESTAMP")
	private LocalTime delivery_timestamp;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getConsumer_id() {
		return consumer_id;
	}

	public void setConsumer_id(UUID consumer_id) {
		this.consumer_id = consumer_id;
	}

	public UUID getMessage_id() {
		return message_id;
	}

	public void setMessage_id(UUID message_id) {
		this.message_id = message_id;
	}

	public LocalTime getDelivery_timestamp() {
		return delivery_timestamp;
	}

	public void setDelivery_timestamp(LocalTime delivery_timestamp) {
		this.delivery_timestamp = delivery_timestamp;
	}

}
