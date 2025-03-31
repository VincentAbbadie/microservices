package fr.va.messagebroker.domain.producer;

import java.util.UUID;

public class ProducerService {

	private ProducerServiceProxy producerServiceProxy;

	public ProducerService(ProducerServiceProxy producerServiceProxy) {
		this.producerServiceProxy = producerServiceProxy;
	}

	public Iterable<Producer> findAllProducer() {
		return producerServiceProxy.findAllProducers();
	}

	public Producer findProducer(UUID producerId) {
		return producerServiceProxy.findProducer(producerId);
	}

}
