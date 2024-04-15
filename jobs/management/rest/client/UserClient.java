package jobs.management.rest.client;

import org.apache.cxf.jaxrs.client.*;
import jobs.management.rest.data.User;
import jobs.management.rest.service.JobSearch;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * A client class for interacting with the User web service and performing job searches.
 */
public class UserClient {
    public static final String webServiceUrl = "http://localhost:8080/jobs.management.rest/api/users";

    public static void main(String[] args) {
        // Initialize example users with various details
        User alice = new User("Alice", "Smith", "alice@example.com", "1234567890", "123 Street, City", 30, "Bachelor's", "Professional in IT", "Paris");
        User bob = new User("Bob", "Jones", "bob@example.com", "0987654321", "456 Avenue, City", 35, "Master's", "Experienced manager", "New York");
        User charlie = new User("Charlie", "Brown", "charlie@example.com", "2345678901", "789 Road, City", 28, "Bachelor's", "Software Engineer", "Berlin");

        // Add users to the system
        System.out.println("Adding users:");
        alice.setId(add(alice));
        bob.setId(add(bob));
        charlie.setId(add(charlie));

        // Update details for one user
        System.out.println("\nUpdating Alice's information:");
        User userToUpdate = new User("Alice", "UpdatedLastName", "alice@example.com", "1234567890", "123 Street, City", 30, "Bachelor's", "Updated Professional", "London");
        userToUpdate.setId(alice.getId());
        update(userToUpdate.getId(), userToUpdate);

        // Perform job search for each user and print results
        System.out.println("\nJob Search Results for Updated Alice:");
        printJobSearchResults(searchJob(userToUpdate));

        System.out.println("\nJob Search Results for Bob:");
        printJobSearchResults(searchJob(bob));

        System.out.println("\nJob Search Results for Charlie:");
        printJobSearchResults(searchJob(charlie));

        // Get a user from the system
        User newuser = get(2); 
        newuser.toString();
        
        // Delete a user from the system
        System.out.println("\nDeleting Charlie:");
        //delete(charlie.getId());
    }

    /**
     * Adds a new user to the system.
     * @param user The User object to be added.
     * @return The ID of the added user or null if the operation failed.
     */
    
    public static Integer add(User user) {
        System.out.print("Adding " + user.getFirstName() + "... ");
        WebClient client = WebClient.create(webServiceUrl);
        Response r = client.type(MediaType.APPLICATION_XML).post(Entity.entity(user, MediaType.APPLICATION_XML));
        if (r.getStatus() == Response.Status.CREATED.getStatusCode()) {
            System.out.println("User added successfully.");
        	String uri = r.getHeaderString("Content-Location");
            return Integer.parseInt(uri.substring(uri.lastIndexOf('/') + 1));
        } else {
            System.out.println("Failed to add user.");
            return null;
        }
    }

    /**
     * Retrieves a user from the system by ID.
     * @param id The ID of the user to retrieve.
     * @return The User object if found, null otherwise.
     */
    public static User get(Integer id) {
    	System.out.print("Getting " + id + "... ");
    	WebClient c = WebClient.create(webServiceUrl).path(id);
        User user = c.get(User.class);
        if (user != null) {
            System.out.println("User retrieved: " + user.toString());
            return user;
        } else {
            System.out.println("User not found.");
            return null;
        }
	}

    /**
     * Deletes a user from the system by ID.
     * @param id The ID of the user to be deleted.
     * @return true if the deletion was successful, false otherwise.
     */
    public static Boolean delete(Integer id) {
    	System.out.print("Deleting " + id + "... ");
    	WebClient c = WebClient.create(webServiceUrl).path(id);
        Response r = c.delete();
        if (r.getStatus() == Response.Status.OK.getStatusCode()) {
            System.out.println("User deleted successfully.");
            return true;
        } else {
            System.out.println("Failed to delete user.");
            return false;
        }
    }

    /**
     * Updates the details of an existing user in the system.
     * @param id The ID of the user to update.
     * @param user The new details for the user.
     * @return true if the update was successful, false otherwise.
     */
    public static boolean update(Integer id, User user) {
        System.out.print("Updating user " + id + "... ");
        WebClient c = WebClient.create(webServiceUrl).path(id);
        Response r = c.type(MediaType.APPLICATION_XML).put(Entity.entity(user, MediaType.APPLICATION_XML));

        if (r.getStatus() == Response.Status.OK.getStatusCode()) {
            System.out.println("User updated successfully.");
            return true;
        } else {
            System.out.println("Failed to update user.");
            return false;
        }
    }

    /**
     * Searches for jobs based on the details of a user.
     * @param user The user whose details will be used for the job search.
     * @return A JSON string representing the job search results.
     */
    public static String searchJob(User user) {
        return JobSearch.getJobs(user);
    }
    
    /**
     * Searches for jobs based on the location or query.
     * @param query the query or location.
     * @return A JSON string representing the job search results.
     */
    public String searchJob(String query) {
    	return JobSearch.getJobs(query);
    }

    /**
     * Prints the job search results in a human-readable format.
     * @param jsonResponse The JSON string containing the job search results.
     */
    public static void printJobSearchResults(String jsonResponse) {
        if (jsonResponse == null || jsonResponse.trim().isEmpty()) {
            System.out.println("No results found.");
            return;
        }

        try {
            JSONObject responseObj = new JSONObject(jsonResponse);
            if (responseObj.has("data")) {
                JSONArray jobs = responseObj.getJSONArray("data");
                for (int i = 0; i < (jobs.length() > 5 ? 5 : jobs.length()) ; i++) {
                    JSONObject job = jobs.getJSONObject(i);
                    System.out.println("Job Title: " + job.optString("job_title"));
                    System.out.println("Company: " + job.optString("employer_name"));
                    //System.out.println("Location: " + job.optString("job_location"));
                    //System.out.println("Description: " + job.optString("job_description"));
                    System.out.println("---------------------------------------------------");
                }
            } else {
                System.out.println("No job data found.");
            }
        } catch (Exception e) {
            System.out.println("Error parsing job search results: " + e.getMessage());
        }
    }

}
