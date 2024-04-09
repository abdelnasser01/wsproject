
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package jobs.ws.client;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.5.7
 * 2024-04-09T04:29:07.962+02:00
 * Generated source version: 3.5.7
 *
 */

@javax.jws.WebService(
                      serviceName = "UserManagementImplService",
                      portName = "UserManagementImplPort",
                      targetNamespace = "http://org.ws.jobs/soap/service",
                      wsdlLocation = "file:/Users/abdelnassertine/informatique/Java/web-service/test/soap/eclipse/src/main/webapp/wsdl/usermanagementimpl.wsdl",
                      endpointInterface = "jobs.ws.client.UserManagementImpl")

public class UserManagementImplPortImpl implements UserManagementImpl {

    private static final Logger LOG = Logger.getLogger(UserManagementImplPortImpl.class.getName());

    /* (non-Javadoc)
     * @see jobs.ws.client.UserManagementImpl#addUser(jobs.ws.client.User user)*
     */
    public jobs.ws.client.User addUser(jobs.ws.client.User user) {
        LOG.info("Executing operation addUser");
        System.out.println(user);
        try {
            jobs.ws.client.User _return = new jobs.ws.client.User();
            _return.setAddress("Address-1939406424");
            _return.setAge(917666477);
            java.util.List<java.lang.String> _returnCertifications = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnCertificationsVal1 = "_returnCertificationsVal-1919501453";
            _returnCertifications.add(_returnCertificationsVal1);
            _return.getCertifications().addAll(_returnCertifications);
            _return.setEducationLevel("EducationLevel-518946158");
            _return.setEmail("Email-714060244");
            _return.setFirstName("FirstName1690196512");
            _return.setId(562930271);
            java.util.List<java.lang.String> _returnLanguages = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnLanguagesVal1 = "_returnLanguagesVal-394550631";
            _returnLanguages.add(_returnLanguagesVal1);
            _return.getLanguages().addAll(_returnLanguages);
            _return.setLastName("LastName994295438");
            _return.setLookingForJob(false);
            _return.setPhoneNumber("PhoneNumber526263162");
            _return.setProfessionalSummary("ProfessionalSummary1264155029");
            java.util.List<java.lang.String> _returnSkills = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnSkillsVal1 = "_returnSkillsVal1732133603";
            _returnSkills.add(_returnSkillsVal1);
            _return.getSkills().addAll(_returnSkills);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see jobs.ws.client.UserManagementImpl#getUser(int id)*
     */
    public jobs.ws.client.User getUser(int id) {
        LOG.info("Executing operation getUser");
        System.out.println(id);
        try {
            jobs.ws.client.User _return = new jobs.ws.client.User();
            _return.setAddress("Address840550276");
            _return.setAge(-487388955);
            java.util.List<java.lang.String> _returnCertifications = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnCertificationsVal1 = "_returnCertificationsVal-1457104601";
            _returnCertifications.add(_returnCertificationsVal1);
            _return.getCertifications().addAll(_returnCertifications);
            _return.setEducationLevel("EducationLevel313099036");
            _return.setEmail("Email-463629930");
            _return.setFirstName("FirstName-1430972883");
            _return.setId(760212980);
            java.util.List<java.lang.String> _returnLanguages = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnLanguagesVal1 = "_returnLanguagesVal573618550";
            _returnLanguages.add(_returnLanguagesVal1);
            _return.getLanguages().addAll(_returnLanguages);
            _return.setLastName("LastName1609601658");
            _return.setLookingForJob(true);
            _return.setPhoneNumber("PhoneNumber-1667398743");
            _return.setProfessionalSummary("ProfessionalSummary1302609975");
            java.util.List<java.lang.String> _returnSkills = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnSkillsVal1 = "_returnSkillsVal-1422453171";
            _returnSkills.add(_returnSkillsVal1);
            _return.getSkills().addAll(_returnSkills);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see jobs.ws.client.UserManagementImpl#deleteUser(int id)*
     */
    public boolean deleteUser(int id) {
        LOG.info("Executing operation deleteUser");
        System.out.println(id);
        try {
            boolean _return = false;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see jobs.ws.client.UserManagementImpl#updateUser(int id, jobs.ws.client.User user)*
     */
    public jobs.ws.client.User updateUser(int id, jobs.ws.client.User user) {
        LOG.info("Executing operation updateUser");
        System.out.println(id);
        System.out.println(user);
        try {
            jobs.ws.client.User _return = new jobs.ws.client.User();
            _return.setAddress("Address402195774");
            _return.setAge(-595868010);
            java.util.List<java.lang.String> _returnCertifications = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnCertificationsVal1 = "_returnCertificationsVal1251588598";
            _returnCertifications.add(_returnCertificationsVal1);
            _return.getCertifications().addAll(_returnCertifications);
            _return.setEducationLevel("EducationLevel52389894");
            _return.setEmail("Email1251032445");
            _return.setFirstName("FirstName34758906");
            _return.setId(-2070476478);
            java.util.List<java.lang.String> _returnLanguages = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnLanguagesVal1 = "_returnLanguagesVal-1009318322";
            _returnLanguages.add(_returnLanguagesVal1);
            _return.getLanguages().addAll(_returnLanguages);
            _return.setLastName("LastName-1564402747");
            _return.setLookingForJob(false);
            _return.setPhoneNumber("PhoneNumber1523473231");
            _return.setProfessionalSummary("ProfessionalSummary955903640");
            java.util.List<java.lang.String> _returnSkills = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnSkillsVal1 = "_returnSkillsVal-643825397";
            _returnSkills.add(_returnSkillsVal1);
            _return.getSkills().addAll(_returnSkills);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
