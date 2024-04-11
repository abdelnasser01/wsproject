package jobs.management.soap.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import jobs.management.soap.model.User;

/**
 * A class to search for job listings using the JSearch API.
 */
public class JobSearch {
    // Base URL of the JSearch API
    private static final String API_URL = "https://jsearch.p.rapidapi.com/search";
    // API key for accessing the JSearch API
    private static final String API_KEY = "ddb5addfc5msh032a0b956e4abe9p199a4bjsn21389503602e";

    /**
     * Searches for jobs based on a query string.
     * 
     * @param query The query string used for the job search.
     * @return A string containing the search results.
     */
    public static String getJobs(String query) {
        // Create a new HttpClient instance
        HttpClient client = HttpClient.newHttpClient();
        // Encode the query string to ensure it's formatted correctly for the URL
        String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);
        // Construct the final URL with the encoded query
        String url = API_URL + "?query=" + encodedQuery;

        // Build the HTTP request
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("X-RapidAPI-Key", API_KEY)  // Include the API key in the request header
            .header("X-RapidAPI-Host", "jsearch.p.rapidapi.com")
            .method("GET", HttpRequest.BodyPublishers.noBody())  // Use the GET method
            .build();

        // Send the HTTP request and return the response
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();  // Return the response body as a string
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();  // Print the stack trace in case of an exception
            return null;  // Return null if an error occurs
        }
    }

    /**
     * Overloaded method to search for jobs based on a user's location and professional summary.
     * 
     * @param user The user object containing location and professional summary data.
     * @return A string containing the search results.
     */
	public static String getJobs(jobs.management.soap.client.User user) {
        // Construct a query using the user's location and professional summary
        String query = user.getLocation() + " " + user.getProfessionalSummary();
        // Use the getJobs method to perform the search
        return getJobs(query);
	}
}