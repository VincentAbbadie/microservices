package fr.va.messagebroker.domain.consumer;

import java.util.List;

public class ConsumerService {

	private ConsumerServiceProxy consumerServiceProxy;

	public ConsumerService(ConsumerServiceProxy consumerServiceProxy) {
		this.consumerServiceProxy = consumerServiceProxy;
	}

	public List<Consumer> findAllConsumers() {
		return consumerServiceProxy.findAllConsumers();
	}

}
