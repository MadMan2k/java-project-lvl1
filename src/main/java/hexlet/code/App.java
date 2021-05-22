package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String welcome = "Welcome to the Brain Games!";
        final int numberOfChoice = 4;
        String[] availableChoice = new String[numberOfChoice];
        final int exit0 = 0;
        final int greet1 = 1;
        final int even2 = 2;
        final int calc3 = 3;
        availableChoice[exit0] = "0 - Exit";
        availableChoice[greet1] = "1 - Greet";
        availableChoice[even2] = "2 - Even";
        availableChoice[calc3] = "3 - Calc";
        System.out.println("Please enter the game number and press Enter.");
        for (int i = 1; i < availableChoice.length; i++) {
            System.out.println(availableChoice[i]);
        }
        System.out.println(availableChoice[exit0]);
        Scanner setGame = new Scanner(System.in);
        System.out.print("Your choice : ");
        String choosedGame = setGame.nextLine();
        System.out.println();

        switch (choosedGame) {
            case "0":
                System.out.println("Not ready, TODO");
                break;
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
