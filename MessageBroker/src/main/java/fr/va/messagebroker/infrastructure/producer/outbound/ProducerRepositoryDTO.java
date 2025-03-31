package fr.va.messagebroker.infrastructure.producer.outbound;

import java.util.Set;
import java.util.UUID;

import fr.va.messagebroker.infrastructure.channel.outbound.ChannelRepositoryDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "producers")
public class ProducerRepositoryDTO {

	@Id
	@Column(name = "ID")
	private UUID id;

	@Column(name = "name")
	private String name;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "product_to_channel", joinColumns = @JoinColumn(name = "PRODUCERS_ID_FK"), inverseJoinColumns = @JoinColumn(name = "CHANNELS_ID_FK"))
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
