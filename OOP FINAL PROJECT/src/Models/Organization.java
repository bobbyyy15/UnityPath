package Models;

import java.util.Scanner;

public class Organization {
    private int id;
    private String name;
    private String password;

    public Organization(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Organization(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    // Menu system with exit choice for Organization
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Welcome to the Organization Manager");
            System.out.println("1. Create Organization");
            System.out.println("2. View Organizations");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left by nextInt()

            switch (choice) {
                case 1:
                    // Example: Create an Organization
                    try {
                        System.out.println("Enter Organization name: ");
                        String name = scanner.nextLine();

                        System.out.println("Enter Organization password: ");
                        String password = scanner.nextLine();

                        Organization organization = new Organization(name, password);
                        System.out.println("Organization created successfully: " + organization);

                    } catch (Exception e) {
                        System.out.println("Error creating organization: " + e.getMessage());
                    }
                    break;

                case 2:
                    // Example: View Organizations
                    System.out.println("Viewing Organizations...");
                    // You would implement viewing logic here (e.g., printing a list of
                    // organizations)
                    break;

                case 3:
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
