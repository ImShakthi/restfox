package com.restfox.rest.service.application;

import org.glassfish.jersey.server.ResourceConfig;

public class RESTApplication extends ResourceConfig {

	public RESTApplication() {
		packages("com.restfox");
	}
}
