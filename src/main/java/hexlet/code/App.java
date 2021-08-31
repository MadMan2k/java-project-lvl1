package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
    final static int EXIT_0 = 0;
    final static int GREET_1 = 1;
    final static int EVEN_2 = 2;
    final static int CALC_3 = 3;
    final static int GCD_4 = 4;
    final static int PROGRESSION_5 = 5;
    final static int PRIME_6 = 6;

    public static void main(String[] args) {
        printGameMenu();
        System.out.println("Please enter the game number and press Enter.");
        Scanner setGame = new Scanner(System.in);
        System.out.print("Your choice : ");
        int selectedGame = setGame.nextInt();
        System.out.println();
        if (selectedGame != EXIT_0) {
            System.out.println("Welcome to the Brain Games!");
            Engine.setPlayerName();
            switch (selectedGame) {
                case GREET_1:
                    break;
                case EVEN_2:
                    Even.evenGame();
                    break;
                case CALC_3:
                    Calc.calcGame();
                    break;
                case GCD_4:
                    GCD.gcdGame();
                    break;
                case PROGRESSION_5:
                    Progression.progressionGame();
                    break;
                case PRIME_6:
                    Prime.primeGame();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void printGameMenu() {
        System.out.println("0 - Exit");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
    }
}
