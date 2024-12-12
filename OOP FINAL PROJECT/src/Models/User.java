package Models;

import java.util.UUID;

public abstract class User {
    protected String id;
    protected String name;
    protected String email;

    public User(String name, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Abstract method to be implemented by subclasses
    public abstract void viewOpportunities();
}
