package fr.va.messagebroker.infrastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class RequestLoggingFilter extends AbstractRequestLoggingFilter {

	private static final Logger LOGGER = LoggerFactory.getLogger(RequestLoggingFilter.class);

	@Override
	protected void beforeRequest(HttpServletRequest request, String message) {
		LOGGER.info(request.getMethod() + " " + request.getRequestURI());
	}

	@Override
	protected void afterRequest(HttpServletRequest request, String message) {
	}

}
