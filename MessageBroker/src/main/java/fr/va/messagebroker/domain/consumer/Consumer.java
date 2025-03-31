package fr.va.messagebroker.domain.consumer;

import java.util.Set;
import java.util.UUID;

import fr.va.messagebroker.domain.channel.Channel;

public class Consumer {

	private UUID id;

	private String name;

	private Set<Channel> channels;

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

	public Set<Channel> getChannels() {
		return channels;
	}

	public void setChannels(Set<Channel> channels) {
		this.channels = channels;
	}

}
