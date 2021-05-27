package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String welcome = "Welcome to the Brain Games!";
        final int numberOfChoice = 6;
        String[] availableChoice = new String[numberOfChoice];
        final int exit0 = 0;
        final int greet1 = 1;
        final int even2 = 2;
        final int calc3 = 3;
        final int gcd4 = 4;
        final int progression5 = 5;
        availableChoice[exit0] = "0 - Exit";
        availableChoice[greet1] = "1 - Greet";
        availableChoice[even2] = "2 - Even";
        availableChoice[calc3] = "3 - Calc";
        availableChoice[gcd4] = "4 - GCD";
        availableChoice[progression5] = "5 - Progression";
        System.out.println("Please enter the game number and press Enter.");

        for (int i = 1; i < availableChoice.length; i++) {
            System.out.println(availableChoice[i]);
        }
        System.out.println(availableChoice[exit0]);
        Scanner setGame = new Scanner(System.in);
        System.out.print("Your choice : ");
        int selectedGame = setGame.nextInt();
        System.out.println();
        System.out.println(welcome);
        Cli.setName();

        switch (selectedGame) {
            case exit0:
                System.out.println("Not ready, TODO");
                break;
            case greet1:
                break;
            case even2:
                Even.evenGame();
                break;
            case calc3:
                Calc.calcGame();
                break;
            case gcd4:
                GCD.gcdGame();
                break;
            case progression5:
                Progression.progressionGame();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
