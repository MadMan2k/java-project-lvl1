package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static final int NUMBER_OF_TRIES = 3;
    public static final String YES_TEXT = "yes";
    public static final String NO_TEXT = "no";

    public static String getNameFromPlayer() {
        System.out.print("May I have your name? ");
        Scanner playerNameScanner = new Scanner(System.in);
        return playerNameScanner.nextLine();
    }

    public static void runGame(String rules, String[] gameQuestions, String[] rightAnswers) {
        String playerName = getNameFromPlayer();
        System.out.println("Hello, " + playerName + "!");
        Scanner getAnswerFromPlayer = new Scanner(System.in);
        int counterOfCorrectAnswers = 0;
        System.out.println(rules);
        for (int i = 0; i < NUMBER_OF_TRIES; i++) {
            System.out.print("Question: ");
            System.out.println(gameQuestions[i]);
            System.out.print("Your answer : ");
            String playerAnswer = getAnswerFromPlayer.nextLine();
            if (!rightAnswers[i].equals(playerAnswer)) {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'%n", playerAnswer, rightAnswers[i]);
                System.out.println("Let's try again, " + playerName + "!");
                break;
            } else {
                System.out.println("Correct!");
                counterOfCorrectAnswers++;
            }
        }
        if (counterOfCorrectAnswers == NUMBER_OF_TRIES) {
            System.out.println("Congratulations, " + playerName + "!");
        }
    }
}
