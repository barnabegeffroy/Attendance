package io.github.oliviercailloux.attendance;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("db")
@RequestScoped
public class DbResource {

	@Inject
	EntityManager em;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String call() {
		return em.toString();
	}
}
