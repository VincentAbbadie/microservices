package fr.va.messagebroker.domain.channel;

import java.util.Set;
import java.util.UUID;

import fr.va.messagebroker.domain.consumer.Consumer;
import fr.va.messagebroker.domain.producer.Producer;

public class Channel {

	private UUID id;

	private String name;

	private Set<Producer> producers;

	private Consumer consumer;

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

	public Set<Producer> getProducers() {
		return producers;
	}

	public void setProducers(Set<Producer> producers) {
		this.producers = producers;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

}
