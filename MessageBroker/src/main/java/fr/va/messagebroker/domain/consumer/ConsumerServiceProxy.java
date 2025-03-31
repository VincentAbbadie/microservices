package fr.va.messagebroker.domain.consumer;

import java.util.List;
import java.util.UUID;

public interface ConsumerServiceProxy {

	public List<Consumer> findAllConsumers();

	public Consumer findConsumer(UUID consumerId);

}
