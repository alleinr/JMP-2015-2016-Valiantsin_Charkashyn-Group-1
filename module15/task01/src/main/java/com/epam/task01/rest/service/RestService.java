package com.epam.task01.rest.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.epam.task01.rest.dao.UserDAO;
import com.epam.task01.rest.model.User;

@Path("/user")
public class RestService {
	 
		@GET
		@Path("/get/{id}")
		public Response getUser(@PathParam("id") String id) {
			System.out.println("getId " + id);
			User user = new UserDAO().getUser(id);	 
			return Response.status(200).entity(user).build();	 
		}
		
		@GET
		@Path("/getall")
		public Response getAll() {
			System.out.println("getAll");
			List<User> users = new UserDAO().getAll();	 
			return Response.status(200).entity(users).build();
	 
		}
		
		@GET
		@Path("/create/{id}/{lastName}/{firstName}/{email}/{login}")
		@Produces(MediaType.APPLICATION_XML)
		public User createUser(@PathParam("id") String id, @PathParam("lastName") String lastName, @PathParam("firstName") String firstName,
				@PathParam("email") String email, @PathParam("login") String login) {
			System.out.println("createUser ");
			User user = new User();
			user.setId(id);
			user.setEmail(email);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setLogin(login);					
			user = new UserDAO().createUser(user);	 
			return user;	 
		}
		
		@GET
		@Path("/update/{id}/{lastName}/{firstName}/{email}/{login}")
		@Produces(MediaType.APPLICATION_JSON)
		public User updateUser(@PathParam("id") String id, @PathParam("lastName") String lastName, @PathParam("firstName") String firstName,
				@PathParam("email") String email, @PathParam("login") String login) {
			User user = new User();
			user.setId(id);
			user.setEmail(email);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setLogin(login);					
			user = new UserDAO().updateUser(user);	 
			return user;	 
		}
		
		@GET
		@Path("/delete/{id}")
		public Response deleteUser(@PathParam("id") String id) {
			System.out.println("delete " + id);
			boolean status = new UserDAO().removeUser(id);	 
			return Response.status(200).entity(status).build();	 
		}
		
}
