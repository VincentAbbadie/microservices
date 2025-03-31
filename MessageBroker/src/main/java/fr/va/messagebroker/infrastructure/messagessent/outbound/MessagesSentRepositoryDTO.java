package fr.va.messagebroker.infrastructure.messagessent.outbound;

import java.time.LocalTime;

import fr.va.messagebroker.infrastructure.consumer.outbound.ConsumerRepositoryDTO;
import fr.va.messagebroker.infrastructure.messages.outbound.MessageRepositoryDTO;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "messages_sent")
public class MessagesSentRepositoryDTO {

	@EmbeddedId
	private MessageSentRepositryPrimaryKey primaryKey;

	@ManyToOne
//	@JoinColumn(name = "CONSUMER_ID_FK")
	private ConsumerRepositoryDTO consumer_id;

	@ManyToOne
//	@JoinColumn(name = "MESSAGES_ID_FK")
	private MessageRepositoryDTO message_id;

	@Column(name = "DELIVERY_TIMESTAMP")
	private LocalTime delivery_timestamp;

	public ConsumerRepositoryDTO getConsumer_id() {
		return consumer_id;
	}

	public void setConsumer_id(ConsumerRepositoryDTO consumer_id) {
		this.consumer_id = consumer_id;
	}

	public MessageRepositoryDTO getMessage_id() {
		return message_id;
	}

	public void setMessage_id(MessageRepositoryDTO message_id) {
		this.message_id = message_id;
	}

	public LocalTime getDelivery_timestamp() {
		return delivery_timestamp;
	}

	public void setDelivery_timestamp(LocalTime delivery_timestamp) {
		this.delivery_timestamp = delivery_timestamp;
	}

}
