package io.github.oliviercailloux.jetty;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("list")
@RequestScoped
public class StudentsList {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public JsonArray asJson() {
		JsonArray list = Json.createArrayBuilder().build();
		String data = "Bertrand Russell,Friedrich Frege";
		String[] students = data.split(",");
		for (String s : students) {
			String[] id = s.split(" ");
			JsonObject name = Json.createObjectBuilder()
					.add("First Name", id[0])
					.add("Last Name", id[1])
					.build();
			list.add(name);
		}
		return list;
	}
}
