
package jobs.ws.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.5.7
 * Tue Apr 09 03:10:28 CEST 2024
 * Generated source version: 3.5.7
 */

@XmlRootElement(name = "deleteUser", namespace = "http://org.ws.jobs/soap/service")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteUser", namespace = "http://org.ws.jobs/soap/service")

public class DeleteUser {

    @XmlElement(name = "id")
    private int id;

    public int getId() {
        return this.id;
    }

    public void setId(int newId)  {
        this.id = newId;
    }

}

