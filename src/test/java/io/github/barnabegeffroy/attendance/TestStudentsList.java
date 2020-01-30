package io.github.barnabegeffroy.attendance;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.json.JsonArray;

import org.glassfish.jersey.client.ClientResponse;
import org.junit.jupiter.api.Test;

import io.github.oliviercailloux.attendance.ListHTML;
import io.github.oliviercailloux.attendance.StudentsList;

class TestStudentsList {

	@Test
	void testJson() {
		StudentsList list = new StudentsList();
		JsonArray asJson = list.asJson();
		assertEquals(
				"[{\"First Name\":\"Bertrand\",\"Last Name\":\"Russell\"},{\"First Name\":\"Friedrich\",\"Last Name\":\"Frege\"}]",
				asJson.toString());
	}
	@Test
	void testHTML() throws IOException {
		ListHTML list = new ListHTML();
		BufferedReader br = new BufferedReader(new FileReader(list.asHTML()));
		 String line;
		 while ((line = br.readLine()) != null) {
		   System.out.println(line);
		 }
	}
}
