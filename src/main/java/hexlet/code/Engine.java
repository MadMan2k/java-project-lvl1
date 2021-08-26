package hexlet.code;

import java.util.Scanner;

public class Engine {

    private static String name;
    public static final int NUMBER_OF_TRIES = 3;
    public static final String YES_TEXT = "yes";
    public static final String NO_TEXT = "no";
    private static int counterOfCorrectAnswers = 0;
    private static final Scanner SET_ANSWER = new Scanner(System.in);

    public static void setPlayerName() {
        name = Cli.getNameFromPlayer();
    }

    private static boolean verifyAnswer(String result, String answer) {
        if (answer.equals(result)) {
            System.out.println("Correct!");
            counterOfCorrectAnswers++;
            return true;
        } else {
            System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'%n", answer, result);
            System.out.println("Let's try again, " + name + "!");
            return false;
        }
    }

    public static void runGame(String rules, String[] gameQuestions, String[] rightAnswers) {
        System.out.println(rules);
        for (int i = 0; i < NUMBER_OF_TRIES; i++) {
            System.out.print("Question: ");
            System.out.println(gameQuestions[i]);
            System.out.print("Your answer : ");
            String playerAnswer = SET_ANSWER.nextLine();
            if (!verifyAnswer(rightAnswers[i], playerAnswer)) {
                break;
            }
        }
        if (counterOfCorrectAnswers == NUMBER_OF_TRIES) {
            System.out.println("Congratulations, " + name + "!");
        }
    }
}
