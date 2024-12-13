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



