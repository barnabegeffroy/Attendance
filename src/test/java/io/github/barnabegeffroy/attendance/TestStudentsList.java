package io.github.barnabegeffroy.attendance;

import static org.junit.jupiter.api.Assertions.*;

import javax.json.JsonArray;

import org.glassfish.jersey.client.ClientResponse;
import org.junit.jupiter.api.Test;

class TestStudentsList {

	@Test
	void test() {
		ClientResponse response = getService("http://localhost:8080/list/").get(ClientResponse.class);
		assertEquals(data,response.getStatus());
	}

}
