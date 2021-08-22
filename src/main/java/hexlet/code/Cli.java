package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String getNameFromPlayer() {
        System.out.print("May I have your name? ");
        Scanner playerNameScanner = new Scanner(System.in);
        String playerName = playerNameScanner.nextLine();
        System.out.println("Hello, " + playerName + "!");
        return playerName;
    }
}
