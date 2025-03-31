package fr.va.messagebroker.infrastructure;

public class NotFoundException extends RuntimeException {

	public NotFoundException(Throwable t) {
		super(t);
	}
}
