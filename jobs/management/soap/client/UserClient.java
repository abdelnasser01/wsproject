package jobs.management.soap.client;

import java.net.URL;
import javax.xml.namespace.QName;

import org.json.JSONArray;
import org.json.JSONObject;

import jobs.management.soap.service.JobSearch;

public final class UserClient {

    private static final QName SERVICE_NAME = new QName("http://www.jobs.management.soap/service", "UserManagementImplService");

    /**
     * Main method to demonstrate user management and job search operations.
     * @param args Command line arguments
     * @throws java.lang.Exception Throws an exception in case of communication errors with the service
     */
    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = UserManagementImplService.WSDL_LOCATION;
        UserManagementImplService ss = new UserManagementImplService(wsdlURL, SERVICE_NAME);
        UserManagementImpl port = ss.getUserManagementImplPort();

        // Create and add example users
        System.out.println("Adding users:");
        User daniel = createUser("Daniel", "Lee", "daniel.lee@example.com", "9876543210", "456 Lane, City", 40, "PhD", "Data Scientist", "Tokyo", port);
        User emma = createUser("Emma", "Wilson", "emma.wilson@example.com", "8765432109", "789 Boulevard, City", 32, "Master's", "UI/UX Designer", "San Francisco", port);
        User fiona = createUser("Fiona", "Chen", "fiona.chen@example.com", "7654321098", "1011 Apartment, City", 29, "Bachelor's", "Marketing Specialist", "Toronto", port);

        // Update user
        System.out.println("\nUpdating Daniel's information:");
        daniel.setLastName("Li");
        daniel.setLocation("Seoul");
        User updatedDaniel = port.updateUser(daniel.getId(), daniel);
        System.out.println("Updated user: " + updatedDaniel.toString());

        // Retrieve user
        System.out.println("\nRetrieving Emma's information:");
        User retrievedEmma = port.getUser(emma.getId());
        System.out.println("Retrieved user: " + retrievedEmma.toString());
        
        // Perform job search for each user and print results
        System.out.println("\nJob Search Results for Updated Daniel:");
        printJobSearchResults(searchJob(updatedDaniel));

        System.out.println("\nJob Search Results for Emma:");
        printJobSearchResults(searchJob(emma));

        System.out.println("\nJob Search Results for Fiona:");
        printJobSearchResults(searchJob(fiona));

        // Delete user
        System.out.println("\nDeleting Fiona:");
        boolean deleteResult = port.deleteUser(fiona.getId());
        System.out.println("Deleted Fiona: " + deleteResult);
    }


    /**
     * Creates a new user with the given details and adds the user through the SOAP service.
     * @param firstName The first name of the user
     * @param lastName The last name of the user
     * @param email The email address of the user
     * @param phoneNumber The phone number of the user
     * @param address The address of the user
     * @param age The age of the user
     * @param educationLevel The education level of the user
     * @param professionalSummary The professional summary of the user
     * @param location The location of the user
     * @param port The SOAP service port
     * @return The created user
     */
    public static User createUser(String firstName, String lastName, String email, String phoneNumber, String address, int age, String educationLevel, String professionalSummary, String location, UserManagementImpl port) {
        System.out.println("Creating user: " + firstName + " " + lastName);
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setAddress(address);
        user.setAge(age);
        user.setEducationLevel(educationLevel);
        user.setProfessionalSummary(professionalSummary);
        user.setLocation(location);
        User addedUser = port.addUser(user);
        System.out.println("Added user: " + addedUser.toString());
        return addedUser;
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
    public static String searchJob(String query) {
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
