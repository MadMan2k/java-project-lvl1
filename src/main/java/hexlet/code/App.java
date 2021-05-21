package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String welcome = "Welcome to the Brain Games!";
        final int numberOfChoice = 4;
        String[] availableChoice = new String[numberOfChoice];
        availableChoice[0] = "0 - Exit";
        availableChoice[1] = "1 - Greet";
        availableChoice[2] = "2 - Even";
        availableChoice[3] = "3 - Calc";
        System.out.println("Please enter the game number and press Enter.");
        for (int i = 1; i < availableChoice.length; i++) {
            System.out.println(availableChoice[i]);
        }
        System.out.println(availableChoice[0]);
        Scanner setGame = new Scanner(System.in);
        System.out.print("Your choice : ");
        String choosedGame = setGame.nextLine();
        System.out.println();

        switch (choosedGame) {
            case "1":
                System.out.println(welcome);
                Cli.setName();
                break;
            case "2":
                System.out.println(welcome);
                Cli.setName();
                Even.evenGame();
                break;
            case "3":
                System.out.println(welcome);
                Cli.setName();
                Calc.calcGame();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
