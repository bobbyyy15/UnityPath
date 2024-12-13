package Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OpportunityManager {
    private static List<Opportunity> opportunities = new ArrayList<>();

    // Method to create a new opportunity
    public static void createOpportunity(String title, String requiredSkills, String postedBy,
            String applicants, LocalDate startDate, LocalDate endDate,
            String location) {
        Opportunity newOpportunity = new Opportunity(title, requiredSkills, postedBy,
                applicants, startDate, endDate, location);
        opportunities.add(newOpportunity);
        System.out.println("Opportunity created successfully!");
    }

    // Method to view all available opportunities
    public static void viewOpportunities() {
        if (opportunities.isEmpty()) {
            System.out.println("No available opportunities at the moment.");
        } else {
            for (Opportunity opportunity : opportunities) {
                System.out.println(opportunity);
            }
        }
    }

    // Method for volunteer to apply to an opportunity
    public static boolean applyForOpportunity(int opportunityId, String volunteerName) {
        for (Opportunity opportunity : opportunities) {
            if (opportunity.getId() == opportunityId) {
                opportunity.setApplicants(opportunity.getApplicants() + ", " + volunteerName);
                System.out.println(volunteerName + " applied for opportunity " + opportunityId);
                return true;
            }
        }
        return false; // Opportunity not found
    }
}
