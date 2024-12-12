package Database;

import java.sql.*;
import java.util.Scanner;

public class VolunteerMatchingSystem {
    private Scanner scanner = new Scanner(System.in);

    // DesignUtils Class for handling print designs
    public static class DesignUtils {

        // Method to print the box header with a title inside the box
        public static void printBoxHeader(String title) {
            String border = "=".repeat(title.length() + 6); // Calculate length for borders
            System.out.println(border);
            System.out.println("|   " + title + "   |");
            System.out.println(border);
        }

        // Clears the screen by printing multiple empty lines
        public static void clearScreen(int lines) {
            for (int i = 0; i < lines; i++) {
                System.out.println();
            }
        }

        private void clearConsole() {
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
    }

    // Main entry point
    public void start() {
        while (true) {
            // Clear the console
            DesignUtils designUtils = new DesignUtils();
            designUtils.clearConsole();

            // Display the main menu
            System.out.println("--- Volunteer Matching System ---");
            System.out.println("1. Register as Organization");
            System.out.println("2. Register as Volunteer");
            System.out.println("3. Login as Organization");
            System.out.println("4. Login as Volunteer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> registerOrganization();
                case 2 -> registerVolunteer();
                case 3 -> loginAsOrganization();
                case 4 -> loginAsVolunteer();
                case 5 -> {
                    System.out.println("Exiting Volunteer Matching System. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Register as an Organization
    private void registerOrganization() {
        DesignUtils.printBoxHeader("Register as Organization");

        System.out.print("Enter organization name: ");
        String name = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        String query = "INSERT INTO Organizations (name, password) VALUES (?, ?)";

        try (Connection conn = VolunteerMatchingDB.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, password);
            stmt.executeUpdate();
            System.out.println("Organization registered successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error registering organization.");
        }
    }

    // Register as a Volunteer
    private void registerVolunteer() {
        DesignUtils.printBoxHeader("Register as Volunteer");

        System.out.print("Enter volunteer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        String query = "INSERT INTO Volunteers (name, password) VALUES (?, ?)";

        try (Connection conn = VolunteerMatchingDB.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, password);
            stmt.executeUpdate();
            System.out.println("Volunteer registered successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error registering volunteer.");
        }
    }

    // Login as an Organization
    private void loginAsOrganization() {
        DesignUtils.printBoxHeader("Logging in as Organization");

        System.out.print("Enter organization name: ");
        String name = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        String query = "SELECT * FROM Organizations WHERE name = ? AND password = ?";

        try (Connection conn = VolunteerMatchingDB.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Login successful! Welcome, " + name);
                    manageOrganization(name);
                } else {
                    System.out.println("Invalid credentials.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error logging in.");
        }
    }

    // Login as a Volunteer
    private void loginAsVolunteer() {
        DesignUtils.printBoxHeader("Logging in as Volunteer");

        System.out.print("Enter volunteer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        String query = "SELECT * FROM Volunteers WHERE name = ? AND password = ?";

        try (Connection conn = VolunteerMatchingDB.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Login successful! Welcome, " + name);
                    manageVolunteer(name);
                } else {
                    System.out.println("Invalid credentials.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error logging in.");
        }
    }

    // Manage Organization Menu
    private void manageOrganization(String orgName) {
        while (true) {
            System.out.println("\n--- Organization Menu ---");
            System.out.println("1. Add Opportunity");
            System.out.println("2. View Posted Opportunities");
            System.out.println("3. View Applicants");
            System.out.println("4. Accept Applicant");
            System.out.println("5. Reject Applicant");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            DesignUtils.clearScreen(500); // Clear screen after choice selection

            switch (choice) {
                case 1 -> addOpportunity(orgName);
                case 2 -> viewPostedOpportunities(orgName);
                case 3 -> viewApplicants(orgName);
                case 4 -> acceptApplicant(orgName);
                case 5 -> rejectApplicant(orgName);
                case 6 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Manage Volunteer Menu
    // Manage Volunteer Menu
    private void manageVolunteer(String volunteerName) {
        while (true) {
            System.out.println("\n--- Volunteer Menu ---");
            System.out.println("1. Apply for Opportunity");
            System.out.println("2. View Schedule");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            DesignUtils.clearScreen(500); // Clear screen after choice selection

            switch (choice) {
                case 1:
                    applyForOpportunity(volunteerName); // Call applyForOpportunity method
                    break;
                case 2:
                    viewSchedule(volunteerName); // Call viewSchedule method
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void applyForOpportunity(String volunteerName) {
        System.out.println("\n--- Available Opportunities ---");
        viewPostedOpportunities(volunteerName); // Show posted opportunities for volunteers to apply to.

        System.out.print("Enter the opportunity ID to apply for: ");
        int oppId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        // Check if the volunteer has already applied for this opportunity
        String checkQuery = "SELECT applicants FROM Opportunities WHERE id = ?";
        try (Connection conn = VolunteerMatchingDB.getConnection();
                PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
            checkStmt.setInt(1, oppId);
            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next()) {
                    String applicants = rs.getString("applicants");
                    // Check if volunteer is already an applicant
                    if (applicants != null && applicants.contains(volunteerName)) {
                        System.out.println("You have already applied for this opportunity.");
                        return;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error checking applicants.");
        }

        // Add the volunteer to the applicants list
        String query = "UPDATE Opportunities SET applicants = CONCAT(IFNULL(applicants, ''), ?) WHERE id = ?";
        try (Connection conn = VolunteerMatchingDB.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, volunteerName + ", ");
            stmt.setInt(2, oppId);
            stmt.executeUpdate();
            System.out.println("You have successfully applied for the opportunity!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error applying for the opportunity.");
        }
    }

    private void viewSchedule(String volunteerName) {
        System.out.println("\n--- Your Applied Opportunities ---");

        // Query to get opportunities where the volunteer is listed as an applicant
        String query = "SELECT id, title, date, location, applicants FROM Opportunities WHERE applicants LIKE ?";

        try (Connection conn = VolunteerMatchingDB.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, "%" + volunteerName + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                boolean hasApplied = false;
                while (rs.next()) {
                    hasApplied = true;
                    int oppId = rs.getInt("id");
                    String title = rs.getString("title");
                    String date = rs.getString("date");
                    String location = rs.getString("location");
                    String applicants = rs.getString("applicants");

                    System.out.println("\nOpportunity ID: " + oppId);
                    System.out.println("Title: " + title);
                    System.out.println("Date: " + date);
                    System.out.println("Location: " + location);
                    System.out.println("Applicants: " + applicants);
                    System.out.println("--------------------------");
                }

                if (!hasApplied) {
                    System.out.println("You haven't applied for any opportunities yet.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error retrieving schedule.");
        }
    }

    // Add Opportunity with Schedule
    private void addOpportunity(String orgName) {
        DesignUtils.printBoxHeader("Add Opportunity");

        System.out.print("Enter opportunity title: ");
        String title = scanner.nextLine();
        System.out.print("Enter required skills: ");
        String skills = scanner.nextLine();
        System.out.print("Enter opportunity start date (YYYY-MM-DD): ");
        String startDate = scanner.nextLine();
        System.out.print("Enter opportunity end date (YYYY-MM-DD): ");
        String endDate = scanner.nextLine();
        System.out.print("Enter opportunity location: ");
        String location = scanner.nextLine();

        String query = "INSERT INTO Opportunities (title, required_skills, posted_by, start_date, end_date, location) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = VolunteerMatchingDB.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, title);
            stmt.setString(2, skills);
            stmt.setString(3, orgName);
            stmt.setString(4, startDate);
            stmt.setString(5, endDate);
            stmt.setString(6, location);
            stmt.executeUpdate();
            System.out.println("Opportunity added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error adding opportunity.");
        }
    }

    // View Posted Opportunities for Organization
    private void viewPostedOpportunities(String volunteerName) {
        System.out.println("\n--- Posted Opportunities ---");

        // Table Header
        System.out.printf("%-5s %-30s %-35s %-15s %-15s %-20s%n", "ID", "Title", "Required Skills", "Start Date",
                "End Date", "Location");

        // Query to get the list of posted opportunities
        String query = "SELECT id, title, required_skills, start_date, end_date, location FROM Opportunities";

        try (Connection conn = VolunteerMatchingDB.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String requiredSkills = rs.getString("required_skills");
                String startDate = rs.getString("start_date");
                String endDate = rs.getString("end_date");
                String location = rs.getString("location");

                // Print each opportunity in the table format
                System.out.printf("%-5d %-30s %-35s %-15s %-15s %-20s%n",
                        id,
                        title != null ? title : "N/A",
                        requiredSkills != null ? requiredSkills : "N/A",
                        startDate != null ? startDate : "N/A",
                        endDate != null ? endDate : "N/A",
                        location != null ? location : "N/A");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error displaying opportunities.");
        }
    }

    // View Applicants for Organization
    private void viewApplicants(String orgName) {
        String query = "SELECT * FROM Opportunities WHERE posted_by = ?";

        try (Connection conn = VolunteerMatchingDB.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, orgName);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String applicants = rs.getString("applicants");

                    System.out.println("\n--- Applicants for Opportunity ID: " + id + " ---");
                    if (applicants == null || applicants.isEmpty()) {
                        System.out.println("No applicants yet.");
                    } else {
                        String[] applicantList = applicants.split(",");
                        System.out.println("Applicants:");
                        for (String applicant : applicantList) {
                            System.out.println("- " + applicant);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error retrieving applicants.");
        }
    }

    // Accept an Applicant for Opportunity
    private void acceptApplicant(String orgName) {
        System.out.print("Enter Opportunity ID to accept applicants for: ");
        int opportunityId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter applicant's name to accept: ");
        String applicantName = scanner.nextLine();

        String query = "SELECT * FROM Opportunities WHERE id = ?";

        try (Connection conn = VolunteerMatchingDB.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, opportunityId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String applicants = rs.getString("applicants");
                    if (applicants != null && applicants.contains(applicantName)) {
                        String acceptedApplicants = rs.getString("accepted_applicants");
                        if (acceptedApplicants == null) {
                            acceptedApplicants = applicantName;
                        } else {
                            acceptedApplicants += "," + applicantName;
                        }

                        String updateQuery = "UPDATE Opportunities SET accepted_applicants = ? WHERE id = ?";
                        try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                            updateStmt.setString(1, acceptedApplicants);
                            updateStmt.setInt(2, opportunityId);
                            updateStmt.executeUpdate();
                            System.out.println(applicantName + " has been accepted for this opportunity!");
                        }
                    } else {
                        System.out.println("Applicant not found or has not applied.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error accepting applicant.");
        }
    }

    // Reject an Applicant for Opportunity
    private void rejectApplicant(String orgName) {
        System.out.print("Enter Opportunity ID to reject applicants for: ");
        int opportunityId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter applicant's name to reject: ");
        String applicantName = scanner.nextLine();

        String query = "SELECT * FROM Opportunities WHERE id = ?";

        try (Connection conn = VolunteerMatchingDB.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, opportunityId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String applicants = rs.getString("applicants");
                    if (applicants != null && applicants.contains(applicantName)) {
                        // Update applicants by removing the rejected applicant
                        applicants = applicants.replace(applicantName, "").replaceAll(",,", ",").replaceAll("^,", "")
                                .replaceAll(",?$", "");

                        String updateQuery = "UPDATE Opportunities SET applicants = ? WHERE id = ?";
                        try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                            updateStmt.setString(1, applicants);
                            updateStmt.setInt(2, opportunityId);
                            updateStmt.executeUpdate();
                            System.out.println(applicantName + " has been rejected for this opportunity.");
                        }
                    } else {
                        System.out.println("Applicant not found or has not applied.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error rejecting applicant.");
        }
    }

    // Main method
    public static void main(String[] args) {
        VolunteerMatchingSystem system = new VolunteerMatchingSystem();
        system.start();
    }
}
