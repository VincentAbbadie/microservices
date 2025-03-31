package fr.va.messagebroker.domain.consumer;

import java.util.List;
import java.util.UUID;

public class ConsumerService {

	private ConsumerServiceProxy consumerServiceProxy;

	public ConsumerService(ConsumerServiceProxy consumerServiceProxy) {
		this.consumerServiceProxy = consumerServiceProxy;
	}

	public List<Consumer> findAllConsumers() {
		return consumerServiceProxy.findAllConsumers();
	}

	public Consumer findConsumer(UUID consumerId) {
		return consumerServiceProxy.findConsumer(consumerId);
	}

}
