package com.github.osgi.service.internal;

import java.util.logging.Logger;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.osgi.service.ServiceUnavailableException;
import org.springframework.stereotype.Component;

@Provider
@Component("serviceUnavailableExceptionMapper")
public class ServiceUnavailableExceptionMapper implements
		ExceptionMapper<ServiceUnavailableException> {

	private static final Logger logger = Logger.getLogger(ServiceUnavailableExceptionMapper.class.getCanonicalName());
	
	public Response toResponse(ServiceUnavailableException e) {
		
		logger.info("Caught exception and remapping to 503: " + e);
		
		return Response.status(Response.Status.SERVICE_UNAVAILABLE)
				.entity("Sorry, try again later.").build();
	}

}
