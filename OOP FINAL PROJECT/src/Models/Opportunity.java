package Models;

import java.time.LocalDate;

public class Opportunity {
    private int id;
    private String title;
    private String requiredSkills;
    private String postedBy;
    private String applicants;
    private LocalDate startDate;
    private LocalDate endDate;
    private String location;

    // Updated Constructor
    public Opportunity(int id, String title, String requiredSkills, String postedBy, String applicants,
            LocalDate startDate, LocalDate endDate, String location) {
        this.id = id;
        this.title = title;
        this.requiredSkills = requiredSkills;
        this.postedBy = postedBy;
        this.applicants = applicants;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
    }

    // Overloaded constructor without 'id' (useful for new entries)
    public Opportunity(String title, String requiredSkills, String postedBy, String applicants, LocalDate startDate,
            LocalDate endDate, String location) {
        this.title = title;
        this.requiredSkills = requiredSkills;
        this.postedBy = postedBy;
        this.applicants = applicants;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(String requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public String getApplicants() {
        return applicants;
    }

    public void setApplicants(String applicants) {
        this.applicants = applicants;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Opportunity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", requiredSkills='" + requiredSkills + '\'' +
                ", postedBy='" + postedBy + '\'' +
                ", applicants='" + applicants + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", location='" + location + '\'' +
                '}';
    }
}
