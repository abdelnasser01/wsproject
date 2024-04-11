package jobs.management.soap.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.5.7
 * 2024-04-12T01:48:18.375+02:00
 * Generated source version: 3.5.7
 *
 */
@WebService(targetNamespace = "http://www.jobs.management.soap/service", name = "UserManagementImpl")
@XmlSeeAlso({ObjectFactory.class})
public interface UserManagementImpl {

    @WebMethod
    @RequestWrapper(localName = "updateUser", targetNamespace = "http://www.jobs.management.soap/service", className = "jobs.management.soap.client.UpdateUser")
    @ResponseWrapper(localName = "updateUserResponse", targetNamespace = "http://www.jobs.management.soap/service", className = "jobs.management.soap.client.UpdateUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public jobs.management.soap.client.User updateUser(

        @WebParam(name = "id", targetNamespace = "")
        int id,
        @WebParam(name = "user", targetNamespace = "")
        jobs.management.soap.client.User user
    );

    @WebMethod
    @RequestWrapper(localName = "deleteUser", targetNamespace = "http://www.jobs.management.soap/service", className = "jobs.management.soap.client.DeleteUser")
    @ResponseWrapper(localName = "deleteUserResponse", targetNamespace = "http://www.jobs.management.soap/service", className = "jobs.management.soap.client.DeleteUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean deleteUser(

        @WebParam(name = "id", targetNamespace = "")
        int id
    );

    @WebMethod
    @RequestWrapper(localName = "getUser", targetNamespace = "http://www.jobs.management.soap/service", className = "jobs.management.soap.client.GetUser")
    @ResponseWrapper(localName = "getUserResponse", targetNamespace = "http://www.jobs.management.soap/service", className = "jobs.management.soap.client.GetUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public jobs.management.soap.client.User getUser(

        @WebParam(name = "id", targetNamespace = "")
        int id
    );

    @WebMethod
    @RequestWrapper(localName = "addUser", targetNamespace = "http://www.jobs.management.soap/service", className = "jobs.management.soap.client.AddUser")
    @ResponseWrapper(localName = "addUserResponse", targetNamespace = "http://www.jobs.management.soap/service", className = "jobs.management.soap.client.AddUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public jobs.management.soap.client.User addUser(

        @WebParam(name = "user", targetNamespace = "")
        jobs.management.soap.client.User user
    );
}
