package fr.va.messagebroker.infrastructure.messagessent.outbound;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class MessageSentRepositryPrimaryKey implements Serializable {

	@Column(name = "MESSAGES_ID_FK")
	private UUID messagesIdFK;

	@Column(name = "CONSUMERS_ID_FK")
	private UUID consumersIdFk;

	public UUID getMessagesIdFK() {
		return messagesIdFK;
	}

	public void setMessagesIdFK(UUID messagesIdFK) {
		this.messagesIdFK = messagesIdFK;
	}

	public UUID getConsumersIdFk() {
		return consumersIdFk;
	}

	public void setConsumersIdFk(UUID consumersIdFk) {
		this.consumersIdFk = consumersIdFk;
	}

}
