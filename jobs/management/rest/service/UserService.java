package jobs.management.rest.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jobs.management.rest.data.User;

/**
 * Service layer handling the database operations for User entities.
 * @author Abdelnasser TINE
 */
public class UserService {
    private Connection connection;

    private final String user = "abdelnassertine";
    private final String password = "";
    private final String database = "ws_users";
    private final String jbdc = "jdbc:postgresql://localhost:5432/";

    /**
     * Establishes a database connection.
     */
    public UserService() {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(jbdc + database, user, password);
            if (this.connection == null) {
                throw new SQLException("Failed to establish connection with the database");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize UserService: " + e.getMessage(), e);
        }
    }
     
    /**
     * Retrieves a User from the database by ID.
     * 
     * @param id The ID of the user to retrieve.
     * @return The User object or null if not found.
     */
    public User getUser(int id) {
        String query = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement pstm = connection.prepareStatement(query)) {
            pstm.setInt(1, id);

            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                	User newUser = new User();
                	  
                	newUser.setId(id);
                	newUser.setFirstName(rs.getString("firstname"));
                	newUser.setLastName(rs.getString("lastname"));
                	newUser.setAge(rs.getInt("age"));
                	newUser.setPhoneNumber(rs.getString("phone"));
                	newUser.setAddress(rs.getString("address"));
                	newUser.setEmail(rs.getString("email"));
                	newUser.setEducationLevel(rs.getString("education_level"));
                	newUser.setProfessionalSummary(rs.getString("professional_summary"));
                	newUser.setLocation(rs.getString("location"));
                	  
                	return newUser;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Generates a new unique ID for a User.
     * 
     * @return A new unique ID.
     */
    private int getNewId() {
        String query = "SELECT id FROM users ORDER BY id DESC LIMIT 1";
        try (PreparedStatement pstm = connection.prepareStatement(query)) {
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                	int newId = rs.getInt("id");
                	newId++;
                	return newId;
                }
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Adds a new User to the database.
     * 
     * @param u The User object to add.
     * @return The added User object with ID assigned.
     */
    public User addUser(User u) {
    	int id = getNewId();
		if(id == 0) {
			return null;
		}
		if (getUser(id) != null) {
		    return null;
		}
		
		u.setId(id);
		
		String query = "INSERT INTO users(id, firstname, lastname, email, phone, address, age, education_level, professional_summary, location) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
		    preparedStatement.setInt(1, id);
		    preparedStatement.setString(2, u.getFirstName());
		    preparedStatement.setString(3, u.getLastName());
		    preparedStatement.setString(4, u.getEmail());
		    preparedStatement.setString(5, u.getPhoneNumber());
		    preparedStatement.setString(6, u.getAddress());
		    preparedStatement.setInt(7, u.getAge());
		    preparedStatement.setString(8, u.getEducationLevel());
		    preparedStatement.setString(9, u.getProfessionalSummary());
		    preparedStatement.setString(10, u.getLocation());
		    
		    int rows = preparedStatement.executeUpdate();
		
		    if (rows == 1) {
		        return u;
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	    return null;
    }

    /**
     * Deletes a User from the database by ID.
     * 
     * @param id The ID of the User to delete.
     * @return true if the deletion was successful, false otherwise.
     */
    public boolean deleteUser(int id) {
		if (getUser(id) == null) {
		    return false;
		}
        String query = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            int rows = preparedStatement.executeUpdate();

            if (rows == 1) {
                  return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    /**
     * Updates a User in the database.
     * 
     * @param id The ID of the User to update.
     * @param u The User object containing the updated details.
     * @return The updated User object.
     */
    public User updateUser(int id, User u) {
        if (getUser(id) == null) {
        	return null;
        }
          
        String query = "UPDATE users SET firstname = ?, lastname = ?, email = ?, phone = ?, address = ?, age = ?, education_level = ?, professional_summary = ?, location = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, u.getFirstName());
			preparedStatement.setString(2, u.getLastName());
			preparedStatement.setString(3, u.getEmail());
			preparedStatement.setString(4, u.getPhoneNumber());
			preparedStatement.setString(5, u.getAddress());
			preparedStatement.setInt(6, u.getAge());
			preparedStatement.setString(7, u.getEducationLevel());
			preparedStatement.setString(8, u.getProfessionalSummary());
		    preparedStatement.setString(9, u.getLocation());
			preparedStatement.setInt(10, id);
			  
			int rows = preparedStatement.executeUpdate();
				
			if (rows == 1) {
				return u;
			}
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        return null;
    }

    /**
     * Retrieves all Users from the database.
     * 
     * @return A list of all Users.
     */
    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setAge(rs.getInt("age"));
                user.setPhoneNumber(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setEmail(rs.getString("email"));
                user.setEducationLevel(rs.getString("education_level"));
                user.setProfessionalSummary(rs.getString("professional_summary"));
            	user.setLocation(rs.getString("location"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    
    /**
     * Checks if the database connection is established.
     * 
     * @return true if the connection is established, false otherwise.
     */
    public boolean isConnected() {
        return this.connection != null;
    }
}
