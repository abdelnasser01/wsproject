# wsproject
This repository is dedicated to the Job Searching Web Service project, a comprehensive solution designed to facilitate job search and management via web services.

## Team Members
- TINE Abdelnasser: tinenasser@icloud.com / abdel-nasser.tine@etu.cyu.fr

## Requirements
This project is built using specific versions of Apache CXF and Apache Tomcat to ensure optimal compatibility and performance:
- Apache CXF version 3.5.7
- Apache Tomcat version 9.0.85

Please ensure you are using these versions to avoid potential compatibility issues.

## Introduction
The wsproject is developed with the intent to provide a robust web service solution for job searching and management. Utilizing both SOAP and RESTful architectures, the project integrates an external REST API, JSearch API, for an enhanced job search experience. Crafted within an educational framework, this project leverages Eclipse IDE's efficient development environment for web services, offering a practical learning experience in web service implementation.

The project showcases two core implementations: a SOAP-based and a REST-based web service, each complemented by client examples demonstrating interaction with the services and the JSearch API. Despite the difference in implementation, both services offer identical functionalities and interact with a common database for user data management.

## Services Description
The REST implementation is accessible at **http://localhost:8080/jobs.management.rest/api/users**, providing an XML object that encapsulates user data from the database.

### REST Services:
- **Add User**: Enables the creation and addition of new user entries. Utilize the POST HTTP method to submit a complete User object, receiving an XML object in response.
  
- **Delete User**: Facilitates user deletion via user ID. Employ the DELETE HTTP method, which expects an XML object.
  
- **Update User**: Allows for user data updates by submitting a User object alongside the user ID. This is achieved through the PUT HTTP method, which accepts and returns an XML object.
  
- **Job Search**: The client offers functionalities to search for job offers by submitting a company name or a User object. This feature exemplifies how the client interfaces with both the internal services and the external JSearch API.

## Clients Description
The project includes client examples for both SOAP and REST implementations. These clients demonstrate how to interact with the web services, showcasing functionalities like adding, updating, and deleting users, as well as searching for job offers. The job search feature, in particular, highlights the integration with the external JSearch API, offering a real-world use case of the service's capabilities.

## Use Case Example
A typical use case scenario would involve a user utilizing the client to search for job offers in their field of specialization and within their preferred location. By inputting their details or specifying a company of interest, they can retrieve relevant job listings, showcasing the practical utility of the wsproject in facilitating job searches and user data management.

In essence, the wsproject serves as an educational tool and a functional web service, offering insights into SOAP and RESTful service development while providing a valuable resource for job search and user management.
