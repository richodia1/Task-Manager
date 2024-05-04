# Task Manager API

The Task Manager API is a RESTful web service designed to manage tasks and users in a task management system.

## Features

- User Management:
    - Create a new user
    - Retrieve a user by ID
    - Update an existing user
    - Delete a user by ID
    - List all users
    - Search for users by name(s)

- Task Management:
    - Create a new task
    - Retrieve a task by ID
    - Update an existing task
    - Delete a task by ID
    - List all tasks

## Technologies Used

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- Maven

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven
- H2 database

### Installation

1. Clone the repository:

   ```bash
   git clone # Task Manager API

The Task Manager API is a RESTful web service designed to manage tasks and users in a task management system.

## Features

- User Management:
    - Create a new user
    - Retrieve a user by ID
    - Update an existing user
    - Delete a user by ID
    - List all users
    - Search for users by name(s)

- Task Management:
    - Create a new task
    - Retrieve a task by ID
    - Update an existing task
    - Delete a task by ID
    - List all tasks

## Technologies Used

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- Maven

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven
- MySQL database

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/richodia1/Task-Manager.git

2. Navigate to the project directory:

cd task-manager-api
Configure the database connection in src/main/resources/application.properties.
Build the project:

mvn clean install
Run the application:

The API endpoints are accessible at http://localhost:8080/swagger-ui/index.html#/
3. Recomendation if additional time can be given on this task for Security Implementation are:
  
   --Risk Assessment: Identify and prioritize potential security risks (validation check).
   --Network Security: Implement firewalls, intrusion detection, and regular updates.
   --Data Security: Encrypt sensitive data, establish backups, and enforce access controls.
   --Access Control: Enforce least privilege, implement strong authentication.
   --Security Awareness: Train employees on security best practices and phishing awareness.
   --Incident Response: Develop a plan for detecting, responding to, and recovering from security incidents.
   --Compliance: Ensure compliance with relevant industry regulations.
   --Continuous Improvement: Monitor, review, and improve security measures regularly
using spring security features for Authentication and authorisation.
