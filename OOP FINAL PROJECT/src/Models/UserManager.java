package Models;

import java.util.ArrayList; // Import ArrayList
import java.util.List; // Import List

public class UserManager {

    // Assuming you have some data structure to store users
    private List<User> users = new ArrayList<>(); // Initialize the users list

    public void registerUser(User user) {
        if (user != null) {
            // Add the user to the list or database
            users.add(user);
            System.out.println(user.getName() + " registered successfully!");
        } else {
            System.out.println("User registration failed.");
        }
    }

    public User loginUser(String email, String password) {
        // Logic to check if user exists and password matches
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
