package fr.va.messagebroker.domain.producer;

import java.util.List;

public class ProducerService {

	private ProducerServiceProxy producerServiceProxy;

	public ProducerService(ProducerServiceProxy producerServiceProxy) {
		this.producerServiceProxy = producerServiceProxy;
	}

	public List<Producer> findAllProducer() {
		return producerServiceProxy.findAllProducers();
	}

}
