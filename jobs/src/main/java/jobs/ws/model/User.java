package jobs.ws.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
      private String firstName;
      private String lastName;
      private String email;
      private String phoneNumber;
      private String address;
      private int age;
      private String educationLevel;
      private String professionalSummary;
      private String[] skills;
      private String[] languages;
      private String[] certifications;
      private boolean isLookingForJob;
      private int id;

      // Constructor without parameters for JAXB
      public User() {
      }

      // Full constructor for easy object creation
      public User(String firstName, String lastName, String email, String phoneNumber, String address, int age,
                  String educationLevel, String professionalSummary, String[] skills, String[] languages,
                  String[] certifications, boolean isLookingForJob) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.address = address;
            this.age = age;
            this.educationLevel = educationLevel;
            this.professionalSummary = professionalSummary;
            this.skills = skills;
            this.languages = languages;
            this.certifications = certifications;
            this.isLookingForJob = isLookingForJob;
      }

      public String getFirstName() {return firstName;}
      public void setFirstName(String firstName) {this.firstName = firstName;}

      public String getLastName() {return lastName;}
      public void setLastName(String lastName) {this.lastName = lastName;}

      public String getEmail() {return email;}
      public void setEmail(String email) {this.email = email;}

      public String getPhoneNumber() {return phoneNumber;}
      public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

      public String getAddress() {return address;}
      public void setAddress(String address) {this.address = address;}

      public int getAge() {return age;}
      public void setAge(int age) {
            if(age < 0)
                  this.age = 0;
            else
                  this.age = age;
      }

      public String getEducationLevel() {return educationLevel;}
      public void setEducationLevel(String educationLevel) {this.educationLevel = educationLevel;}

      public String getProfessionalSummary() {return professionalSummary;}
      public void setProfessionalSummary(String professionalSummary) {this.professionalSummary = professionalSummary;}

      public String[] getSkills() {return skills;}
      public void setSkills(String[] skills) {this.skills = skills;}

      public String[] getLanguages() {return languages;}
      public void setLanguages(String[] languages) {this.languages = languages;}

      public String[] getCertifications() {return certifications;}
      public void setCertifications(String[] certifications) {this.certifications = certifications;}

      public boolean isLookingForJob() {return isLookingForJob;}
      public void setLookingForJob(boolean isLookingForJob) {this.isLookingForJob = isLookingForJob;}

      public int getId() {return id;}
      public void setId(int id) {this.id = id;}

      @Override
      public String toString(){
            return id + "::" + firstName + "::" + lastName;
      }
}
