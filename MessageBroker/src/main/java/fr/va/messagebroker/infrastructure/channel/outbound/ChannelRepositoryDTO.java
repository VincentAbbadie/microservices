package fr.va.messagebroker.infrastructure.channel.outbound;

import java.util.Set;
import java.util.UUID;

import fr.va.messagebroker.infrastructure.consumer.outbound.ConsumerRepositoryDTO;
import fr.va.messagebroker.infrastructure.producer.outbound.ProducerRepositoryDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "channels")
public class ChannelRepositoryDTO {

	@Id
	@Column(name = "ID")
	private UUID id;

	@Column(name = "name")
	private String name;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "product_to_channel", joinColumns = @JoinColumn(name = "CHANNELS_ID_FK"), inverseJoinColumns = @JoinColumn(name = "PRODUCERS_ID_FK"))
	private Set<ProducerRepositoryDTO> producers;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CONSUMERS_ID_FK")
	private ConsumerRepositoryDTO consumer;

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

	public Set<ProducerRepositoryDTO> getProducers() {
		return producers;
	}

	public void setProducers(Set<ProducerRepositoryDTO> producers) {
		this.producers = producers;
	}

	public ConsumerRepositoryDTO getConsumer() {
		return consumer;
	}

	public void setConsumer(ConsumerRepositoryDTO consumer) {
		this.consumer = consumer;
	}

}
