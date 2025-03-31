package fr.va.messagebroker.infrastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {

	private static Logger LOGGER = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

	@ExceptionHandler(value = Exception.class)
	public ErrorDTO handleNotFoundException(Exception nfe, WebRequest r) {
		LOGGER.error(r.toString(), nfe);
		return new ErrorDTO(HttpStatus.NO_CONTENT.value(), HttpStatus.NO_CONTENT.getReasonPhrase(), r.getContextPath());
	}
}
