package jobs.management.rest.resource;

import jobs.management.rest.data.User;
import jobs.management.rest.service.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

/**
 * Resource class for managing users through RESTful web service.
 * Provides functionalities to add, delete, retrieve, and update users.
 * 
 * @author Abdelnasser TINE
 * @see jobs.management.rest.resource.UserResource
 */
@Path("/users")
public class UserResource {
	
	private UserService service;
	
    /**
     * Constructor for UserResource.
     * Initializes the UserService, and throws a WebApplicationException if initialization fails.
     * @throws WebApplicationException if UserService cannot be initialized or is not connected.
     */
    public UserResource() throws WebApplicationException{
        try {
            this.service = new UserService();
        } catch (Exception e) {
            throw new WebApplicationException("Service initialization failed", e, Response.Status.INTERNAL_SERVER_ERROR);
        }

        if (!service.isConnected()) {
            throw new WebApplicationException("Service is not connected to the database", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

	@Context
	UriInfo uriInfo;

	/**
	 * Adds a new user to the system.
	 * @param u The user to add.
	 * @return Response object with the newly created user.
	 */
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addUser(User u) {
		User user = service.addUser(u);
		if (user == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
        }
		URI uri = uriInfo.getRequestUri();
		String newUri = uri.getPath() + "/" + user.getId();
		return Response.status(Response.Status.CREATED).entity(user).contentLocation(uri.resolve(newUri)).build();
	}	

	/**
	 * Deletes a user from the system.
	 * @param id The ID of the user to delete.
	 * @return Response object indicating the outcome of the operation.
	 */
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteUser(@PathParam("id") int id) {
		if (!service.deleteUser(id)) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.status(Response.Status.OK).build();
	}

	/**
	 * Retrieves a user by their ID.
	 * @param id The ID of the user to retrieve.
	 * @return Response object with the requested user.
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getUser(@PathParam("id") int id) {
		User user = service.getUser(id);
		if (user == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		Link link = Link.fromUri(uriInfo.getRequestUri()).rel("self").type("application/xml").build();
		return Response.status(Response.Status.OK).entity(user).links(link).build();
	}

	/**
	 * Retrieves all users.
	 * @return Response object with a list of all users.
	 */
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getAllUsers() {
		List<User> users = service.getAllUsers();
		if (users.isEmpty()) {
			return Response.status(Response.Status.NOT_FOUND).build();
        }
		GenericEntity<List<User>> entity = new GenericEntity<List<User>>(users) {};
		return Response.ok(entity).build();
	}

	/**
	 * Updates the information for an existing user.
	 * @param id The ID of the user to update.
	 * @param user The updated user information.
	 * @return Response object with the updated user.
	 */
 	@PUT
    @Path("/{id}")
 	@Consumes(MediaType.APPLICATION_XML)
 	@Produces(MediaType.APPLICATION_XML)
 	public Response updateUser(@PathParam("id") int id, User user) {
 		if (user == null || user.getId() != id) {
 			return Response.status(Response.Status.BAD_REQUEST).entity("Invalid user data").build();
 		}

 		User existingUser = service.getUser(id);
 		if (existingUser == null) {
 			return Response.status(Response.Status.NOT_FOUND).entity("User not found").build();
 		}

 		User updatedUser = service.updateUser(id, user);
 		if (updatedUser == null) {
 			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("User update failed").build();
 		}

 		URI userUri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(updatedUser.getId())).build();
 		return Response.ok(updatedUser).contentLocation(userUri).build();
 	}
}
