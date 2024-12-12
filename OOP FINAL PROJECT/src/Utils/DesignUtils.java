package Utils;

public class DesignUtils {
    // Clears the screen after a given delay
    public static void clearScreen(int delay) {
        try {
            Thread.sleep(delay); // Adding a delay before clearing screen
            clearConsole(); // Call the clearConsole method
        } catch (Exception e) {
            System.out.println("Error clearing screen: " + e.getMessage());
        }
    }

    // Prints the main menu header
    public static void printMainMenuHeader() {
        clearScreen(1000); // Optional: Adds a delay before printing the header
        System.out.println("===========================================================================");
        System.out.println("|                       UNITYPATH                                       |");
        System.out.println("|             Spreading Unity with Purpose!                             |");
        System.out.println("===========================================================================");
        System.out.println("| Welcome to UNITYPATH, where we aim to create a world of kindness!      |");
        System.out.println("---------------------------------------------------------------------------");
    }

    // Prints the start message with information about the system
    public static void printStart() {
        System.out.println("===========================================================================");
        System.out.println("| Welcome to UNITYPATH, a platform spreading unity with purpose!          |");
        System.out.println("| This platform connects volunteers and organizations to make a difference |");
        System.out.println("| and help communities in need.                                            |");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Program is loading, Please Wait...");
        clearScreen(5000); // Clears the screen after showing the welcome message
    }

    // Method for checking exit input, if the user wants to cancel the action
    public static boolean isExitInput(String input) {
        if (input.equalsIgnoreCase("0") || input.equalsIgnoreCase("exit")) {
            System.out.println("Action canceled.");
            return true;
        }
        return false;
    }

    // Clears the console
    public static void clearConsole() {
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
