package jobs.management.soap.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a user in the job management system.
 * @author Abdelnasser TINE
 */
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
      private int id;
      private String location;

      /**
       * Default constructor required for JAXB
       */
      public User() {
      }

      /**
       * Constructs a User with the specified details.
       *
       * @param firstName The user's first name.
       * @param lastName The user's last name.
       * @param email The user's email address.
       * @param phoneNumber The user's phone number.
       * @param address The user's physical address.
       * @param age The user's age.
       * @param educationLevel The user's level of education.
       * @param professionalSummary A brief professional summary for the user.
       * @param location The user's current location.
       */
      public User(String firstName, String lastName, String email, String phoneNumber, String address, int age,
                  String educationLevel, String professionalSummary, String location) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.address = address;
            this.age =  age <= 0 ? 1 : age;
            this.age = age;
            this.educationLevel = educationLevel;
            this.professionalSummary = professionalSummary;
            this.location = location;
      }

      /**
       * Gets the user's first name.
       * @return The first name of the user.
       */
      public String getFirstName() { return firstName; }

      /**
       * Sets the user's first name.
       * @param firstName The first name to set for the user.
       */
      public void setFirstName(String firstName) { this.firstName = firstName; }

      /**
       * Gets the user's last name.
       * @return The last name of the user.
       */
      public String getLastName() { return lastName; }

      /**
       * Sets the user's last name.
       * @param lastName The last name to set for the user.
       */
      public void setLastName(String lastName) { this.lastName = lastName; }

      /**
       * Gets the user's email address.
       * @return The email address of the user.
       */
      public String getEmail() { return email; }

      /**
       * Sets the user's email address.
       * @param email The email address to set for the user.
       */
      public void setEmail(String email) { this.email = email; }

      /**
       * Gets the user's phone number.
       * @return The phone number of the user.
       */
      public String getPhoneNumber() { return phoneNumber; }

      /**
       * Sets the user's phone number.
       * @param phoneNumber The phone number to set for the user.
       */
      public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

      /**
       * Gets the user's address.
       * @return The address of the user.
       */
      public String getAddress() { return address; }

      /**
       * Sets the user's address.
       * @param address The address to set for the user.
       */
      public void setAddress(String address) { this.address = address; }

      /**
       * Gets the user's age.
       * @return The age of the user.
       */
      public int getAge() { return age; }

      /**
       * Sets the user's age.
       * @param age The age to set for the user. If the age is less than or equal to 0, it will be set to 1.
       */
      public void setAge(int age) { this.age = age <= 0 ? 1 : age; }

      /**
       * Gets the user's education level.
       * @return The education level of the user.
       */
      public String getEducationLevel() { return educationLevel; }

      /**
       * Sets the user's education level.
       * @param educationLevel The education level to set for the user.
       */
      public void setEducationLevel(String educationLevel) { this.educationLevel = educationLevel; }

      /**
       * Gets the user's professional summary.
       * @return The professional summary of the user.
       */
      public String getProfessionalSummary() { return professionalSummary; }

      /**
       * Sets the user's professional summary.
       * @param professionalSummary The professional summary to set for the user.
       */
      public void setProfessionalSummary(String professionalSummary) { this.professionalSummary = professionalSummary; }

      /**
       * Gets the user's location.
       * @return The location of the user.
       */
      public String getLocation() { return location; }

      /**
       * Sets the user's location.
       * @param location The location to set for the user.
       */
      public void setLocation(String location) { this.location = location; }

      /**
       * Gets the user's ID.
       * @return The ID of the user.
       */
      public int getId() { return id; }

      /**
       * Sets the user's ID.
       * @param id The ID to set for the user.
       */
      public void setId(int id) { this.id = id; }

      @Override
      public String toString(){
            return id + "::" + firstName + "::" + lastName;
      }
}

