package io.github.oliviercailloux.attendance;


import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@RequestScoped
public class StudentsList {

	@Produces(MediaType.APPLICATION_JSON)
	public JsonArray asJson() {
		JsonArrayBuilder createArrayBuilder = Json.createArrayBuilder();
		
		String data = "Bertrand Russell,Friedrich Frege";
		String[] students = data.split(",");
		for (String s : students) {
			String[] id = s.split(" ");
			JsonObject name = Json.createObjectBuilder()
					.add("First Name", id[0])
					.add("Last Name", id[1])
					.build();
			createArrayBuilder.add(name);
		}
		JsonArray list = createArrayBuilder.build();
		
		return list;
	}
}
