package fr.va.messagebroker.infrastructure;

public class ErrorDTO {

	private int errorCode;

	private String errorMessage;

	private String url;

	public ErrorDTO(int errorCode, String errorMessage, String url) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.url = url;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getUrl() {
		return url;
	}

}
