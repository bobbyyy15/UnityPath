package Models;

import java.util.Scanner;

public class MainModel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = new UserManager();

        boolean exit = false;
        while (!exit) {
            System.out.println("Welcome to the Volunteer Matching System!");
            System.out.println("1. Register User");
            System.out.println("2. Login User");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    // Register User
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();

                    System.out.print("Enter skills (for volunteer) or leave blank (for organization): ");
                    String skills = scanner.nextLine();

                    // Decide if it's a volunteer or organization
                    System.out.print("Are you a Volunteer (V) or an Organization (O)? ");
                    char userType = scanner.nextLine().toUpperCase().charAt(0);

                    if (userType == 'V') {
                        // Register as Volunteer
                        Volunteer volunteer = new Volunteer(email, name, password, skills);
                        userManager.registerUser(volunteer);
                    } else if (userType == 'O') {
                        // Register as Organization
                        Organization organization = new Organization(email, name, password);
                        userManager.registerUser(organization);
                    } else {
                        System.out.println(
                                "Invalid user type. Please choose either 'V' for Volunteer or 'O' for Organization.");
                    }
                    break;

                case 2:
                    // Login User
                    System.out.print("Enter email: ");
                    String loginEmail = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();

                    // Try to login
                    User user = userManager.loginUser(loginEmail, loginPassword);
                    if (user != null) {
                        System.out.println("Welcome, " + user.getName() + "!");
                    } else {
                        System.out.println("Login failed. Invalid email or password.");
                    }
                    break;

                case 3:
                    // Exit the program
                    System.out.println("Exiting the system. Goodbye!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
