//package com.example.auth.service;
//
////package com.yourapp.service;
//
//import com.example.auth.dao.UserDAO;
//import com.example.auth.util.TokenManager;
//import com.example.auth.dao.UserDAO;
//import com.example.auth.model.User;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//public class AuthService {
//
//    private final UserDAO userDAO;
//    private final TokenManager tokenManager;
//
//    // Constructor to initialize DAO and TokenManager
//    public AuthService(Connection conn) {
//        this.userDAO = new UserDAO(conn);
//        this.tokenManager = new TokenManager();
//    }
//
//    public AuthService(UserDAO userDAO, TokenManager tokenManager) {
//        this.userDAO = null;
//        this.tokenManager = null;
//    }
//
//    // ✅ Signup service (for creating a new user)
//    public String signup(User user) throws SQLException {
//        // Check if the user already exists by checking the username
//        if (userDAO.isUserExists(user.getUsername())) {
//            return null;  // User already exists
//        }
//
//        // Create the new user in the database
//        userDAO.createUser(user);
//
//        // Return the token after successful signup
//        return tokenManager.generateToken(user.getUsername());
//    }
//
//    // ✅ Login service (for authenticating user)
//    public String login(User user) throws SQLException {
//        if (userDAO.validateUser(user.getUsername(), user.getPassword())) {
//            // If user is valid, return a token
//            return tokenManager.generateToken(user.getUsername());
//        } else {
//            // Invalid login credentials
//            return null;
//        }
//    }
//
//    public boolean userExists(String username) {
//        return false;
//    }
//
//    public void registerUser(String username, String password) {
//    }
//
//    public String authenticateUser(String username, String password) {
//        return username;
//    }
//}

package com.example.auth.service;

        import com.example.auth.dao.UserDAO;
        import com.example.auth.util.TokenManager;
        import com.example.auth.model.User;
        import java.sql.SQLException;

public class AuthService {

    private final UserDAO userDAO;
    private final TokenManager tokenManager;

    // Constructor to initialize UserDAO and TokenManager
    public AuthService(UserDAO userDAO, TokenManager tokenManager) {
        this.userDAO = userDAO;
        this.tokenManager = tokenManager;
    }

    // ✅ Signup service (for creating a new user)
    public String signup(User user) throws SQLException {
        // Check if the user already exists by checking the username
        if (userDAO.isUserExists(user.getUsername())) {
            return null;  // User already exists
        }

        // Create the new user in the database
        userDAO.createUser(user);

        // Return the token after successful signup
        return tokenManager.generateToken(user.getUsername());
    }

    // ✅ Login service (for authenticating user)
    public String login(User user) throws SQLException {
        // Validate the user's credentials using the UserDAO
        if (userDAO.validateUser(user.getUsername(), user.getPassword())) {
            // If the user is valid, generate and return a token
            return tokenManager.generateToken(user.getUsername());
        } else {
            // If credentials are invalid, return null (failed login)
            return null;
        }
    }

    // Method to authenticate user using username and password (alternative for calling login)
    public String authenticateUser(String username, String password) throws SQLException {
        User user = new User(username, password);  // Create a new User object
        return login(user);  // Delegate to login method
    }
}
