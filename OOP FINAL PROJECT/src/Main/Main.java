package Main;

import Utils.DesignUtils;
import Database.VolunteerMatchingSystem;

public class Main {

    public static void main(String[] args) {
        // Display the welcome message and clear the screen after a delay
        DesignUtils.printStart();
        pause(3000); // Pause to allow the user to view the welcome message
        clearConsole();

        // Initialize the volunteer matching system
        VolunteerMatchingSystem system = new VolunteerMatchingSystem();

        // Start the main menu
        system.start();
    }

    // Utility method to clear the console
    private static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }

    // Utility method to pause the execution
    private static void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}



Encapsulation
    
public abstract class User {
    private String email;
    private String name;
    private String password;

    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}


 Inheritance

// Volunteer class extending User
public class Volunteer extends User {
    private String skills;
    private String location;

    public Volunteer(String email, String name, String password, String skills) {
        super(email, name, password);
        this.skills = skills;
        this.location = "Unknown"; // Default value
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

Polymorphism

// Polymorphism in viewOpportunities
public abstract class User {
    public abstract void viewOpportunities();
}

public class Volunteer extends User {
    @Override
    public void viewOpportunities() {
        System.out.println("Viewing opportunities tailored for volunteers.");
    }
}

public class Organization extends User {
    @Override
    public void viewOpportunities() {
        System.out.println("Viewing applicants for posted opportunities.");
    }
}

Abstraction

// User.java (Abstract Base Class)
public abstract class User {
    private String email;
    private String name;
    private String password;

    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    // Abstract method - to be implemented by subclasses
    public abstract void viewOpportunities();
}
