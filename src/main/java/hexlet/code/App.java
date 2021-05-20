package hexlet.code;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String welcome = "Welcome to the Brain Games!";
        String[] availableGames = new String[3];
        availableGames[0] = "0 - Exit";
        availableGames[1] = "1 - Greet";
        availableGames[2] = "2 - Even";
        System.out.println("Please enter the game number and press Enter.");
        for (int i = 1; i < availableGames.length; i++) {
            System.out.println(availableGames[i]);
        }
        System.out.println(availableGames[0]);
        Scanner setGame = new Scanner(System.in);
        System.out.print("Your choice : ");
        String choosedGame = setGame.nextLine();
        System.out.println();

        switch (choosedGame) {
            case "1": {
                System.out.println(welcome);
                Cli.setName();
                break;
            }
            case "2": {
                System.out.println(welcome);
                Cli.setName();
                Even.evenGame();
                break;
            }
            default: {
                System.out.println("Invalid choice");
            }
        }
    }
}
