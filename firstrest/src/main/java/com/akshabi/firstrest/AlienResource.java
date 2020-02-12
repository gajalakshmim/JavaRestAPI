package com.akshabi.firstrest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource {
	AlienRepository repo=new AlienRepository();
	//private final String id;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Alien> getAliens() {
		return repo.getAliens();
	}
		@GET
	@Path("alien/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Alien getAlien(@PathParam("id") int id) {
			
	return repo.getAlien(id);
	}


	@POST
	@Path("alien")
	public Alien createAlien(Alien a1) throws Exception {
		System.out.println(a1);
		repo.create(a1);
		return a1;
	}

	
}