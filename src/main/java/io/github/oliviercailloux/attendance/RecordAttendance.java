package io.github.oliviercailloux.attendance;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@javax.ws.rs.Path("recordAttendance")
@RequestScoped
public class RecordAttendance {




	@POST
    @Path("/create")
	public Response getUserDetails( @FormParam("person") List<String> missing) {
		String output = "Les absents sont : " + missing;
		return Response.status(200).entity(output).build();
	}

}
