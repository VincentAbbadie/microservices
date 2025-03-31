package fr.va.messagebroker.domain.producer;

import java.util.UUID;

public interface ProducerServiceProxy {

	public Iterable<Producer> findAllProducers();

	public Producer findProducer(UUID producerId);

}
