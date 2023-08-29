# Workshop3

# **User Management Application**

This application is a simple user management system based on Servlet technology and a database. It offers the following operations for users:

## **Features**

### **User Addition (UserAdd)**
- **Access Path**: `/user/add`
  - **GET**: Redirects to the user addition form (`add.jsp`).
  - **POST**: Retrieves data from the form, creates a new user in the database, and redirects to the user list.

### **User Editing (UserEdit)**
- **Access Path**: `/user/edit`
  - **GET**: Based on the provided user ID, loads user data from the database and passes it to the editing form (`edit.jsp`).
  - **POST**: Updates user data in the database based on the submitted form and redirects to the user list.

### **Displaying User List (UserList)**
- **Access Path**: `/user/list`
  - **GET**: Displays all users from the database in a list (`list.jsp`).

### **User Removal (UserRemove)**
- **Access Path**: `/user/remove`
  - **GET**: Removes the user with the provided ID from the database and redirects to the user list.

## **Technologies and Components**

### **Database Connection (DbUtil)**
- Provides a connection to the database via a data source (DataSource).
- Connection configuration details are stored in the JNDI context.

### **User Model (User)**
- Represents the user structure in the system with fields: ID, username, email, and password.

### **Database Operations related to User (UserDao)**
- Allows creating, reading, updating, and deleting users in the database.
- User passwords are hashed using the BCrypt library before being saved to the database.
