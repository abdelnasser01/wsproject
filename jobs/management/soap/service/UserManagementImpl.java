package jobs.management.soap.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceException;
import javax.jws.WebParam;

import jobs.management.soap.model.User;

/**
 * Web service implementation for managing users.
 * This class provides web methods to add, delete, retrieve, and update users.
 * 
 * @author Abdelnasser TINE
 */
@WebService(targetNamespace = "http://www.jobs.management.soap/service")
public class UserManagementImpl {
      
      private UserService service;
      
      /**
       * Constructor initializes the UserService.
       * Throws a WebServiceException if the service cannot be connected.
       * 
       * @throws WebServiceException if UserService cannot be initialized.
       */
      public UserManagementImpl() throws WebServiceException {
          try {
              this.service = new UserService();
          } catch (Exception e) {
              // Exception thrown if the UserService initialization fails
              throw new WebServiceException("Initialization of UserService failed: " + e.getMessage());
          }

          if (!service.isConnected()) {
              // Exception thrown if the UserService cannot connect
              throw new WebServiceException("UserService is not connected.");
          }
      }

      /**
       * Adds a user to the system.
       *
       * @param user The user to be added.
       * @return The added user with updated information (e.g., assigned ID).
       */
      @WebMethod
      public User addUser(@WebParam(name = "user") User user) {
            return service.addUser(user);
      }

      /**
       * Deletes a user from the system.
       *
       * @param id The ID of the user to be deleted.
       * @return true if the deletion was successful, false otherwise.
       */
      @WebMethod
      public boolean deleteUser(@WebParam(name = "id") int id) {
            return service.deleteUser(id);
      }

      /**
       * Retrieves a user by ID.
       *
       * @param id The ID of the user to retrieve.
       * @return The requested user or null if the user does not exist.
       */
      @WebMethod
      public User getUser(@WebParam(name = "id") int id) {
            return service.getUser(id);
      }

      /**
       * Updates the information for an existing user.
       *
       * @param id The ID of the user to be updated.
       * @param user An object containing the updated user information.
       * @return The updated user object.
       */
      @WebMethod
      public User updateUser(@WebParam(name = "id") int id, @WebParam(name = "user") User user) {
            return service.updateUser(id, user);
      }
}
