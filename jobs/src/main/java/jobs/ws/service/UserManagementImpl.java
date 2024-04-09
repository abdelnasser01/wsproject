package jobs.ws.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.WebParam;
import jobs.ws.model.User;

@WebService(targetNamespace = "http://org.ws.jobs/soap/service")
public class UserManagementImpl {
      private final UserService service = new UserService();

      @WebMethod
      public User addUser(@WebParam(name = "user") User user) {
            return service.addUser(user);
      }

      @WebMethod
      public boolean deleteUser(@WebParam(name = "id") int id) {
            return service.deleteUser(id);
      }

      @WebMethod
      public User getUser(@WebParam(name = "id") int id) {
            return service.getUser(id);
      }

      @WebMethod
      public User updateUser(@WebParam(name = "id") int id,
                             @WebParam(name = "user") User user) {
            return service.updateUser(id, user);
      }
}
