package fr.va.messagebroker.infrastructure.producer.outbound;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface ProducerRepository extends CrudRepository<ProducerRepositoryDTO, UUID> {

}
