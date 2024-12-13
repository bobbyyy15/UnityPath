package Main;

import Utils.DesignUtils;
import Database.VolunteerMatchingSystem;

public class Main {

    public static void printMainMenuHeader() {
        DesignUtils.clearScreen(1000); // Use the clearScreen method from DesignUtils
        System.out.println("===========================================================================");
        System.out.println("|                       UNITYPATH                                       |");
        System.out.println("|             Spreading Unity with Purpose!                             |");
        System.out.println("===========================================================================");
        System.out.println("| Welcome to UNITYPATH, where we aim to create a world of kindness!      |");
        System.out.println("---------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        // Display the welcome message and clear the screen after a delay
        DesignUtils.printStart();

        // Initialize the volunteer matching system
        VolunteerMatchingSystem system = new VolunteerMatchingSystem();

        // Start the main menu
        system.start();
    }
}
