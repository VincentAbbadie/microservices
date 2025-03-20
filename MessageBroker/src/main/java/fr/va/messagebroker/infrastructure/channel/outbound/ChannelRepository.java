package fr.va.messagebroker.infrastructure.channel.outbound;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface ChannelRepository extends CrudRepository<ChannelRepositoryDTO, UUID> {

}
