package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        final int exit0 = 0;
        final int greet1 = 1;
        final int even2 = 2;
        final int calc3 = 3;
        final int gcd4 = 4;
        final int progression5 = 5;
        final int prime6 = 6;
        System.out.println("0 - Exit");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("Please enter the game number and press Enter.");
        Scanner setGame = new Scanner(System.in);
        System.out.print("Your choice : ");
        int selectedGame = setGame.nextInt();
        System.out.println();
        if (selectedGame != exit0) {
            System.out.println("Welcome to the Brain Games!");
            Cli.setName();

            switch (selectedGame) {
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
                case prime6:
                    Prime.primeGame();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
