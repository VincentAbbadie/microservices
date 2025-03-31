package fr.va.messagebroker.infrastructure.consumer.outbound;

import java.util.Set;
import java.util.UUID;

import fr.va.messagebroker.infrastructure.channel.outbound.ChannelRepositoryDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "consumers")
public class ConsumerRepositoryDTO {

	@Id
	@Column(name = "ID")
	private UUID id;

	@Column(name = "NAME")
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "consumer")
	private Set<ChannelRepositoryDTO> channels;

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

	public Set<ChannelRepositoryDTO> getChannels() {
		return channels;
	}

	public void setChannels(Set<ChannelRepositoryDTO> channels) {
		this.channels = channels;
	}

}
