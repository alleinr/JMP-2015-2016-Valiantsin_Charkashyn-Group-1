package com.epam.task01.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/user")
public class RestService {
	 
		@GET
		@Path("/{param}")
		public Response getMsg(@PathParam("param") String msg) {
	 
			String output = "Jersey say : " + msg;
	 
			return Response.status(200).entity(output).build();
	 
		}
}
