package fr.va.messagebroker.infrastructure.consumer.outbound;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface ConsumerRepository extends CrudRepository<ConsumerRepositoryDTO, UUID> {

}
