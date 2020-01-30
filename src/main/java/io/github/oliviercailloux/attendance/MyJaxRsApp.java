package io.github.oliviercailloux.attendance;

import org.glassfish.jersey.server.ResourceConfig;

public class MyJaxRsApp extends ResourceConfig {
	public MyJaxRsApp() {
		packages(getClass().getPackage().toString());
	}
}