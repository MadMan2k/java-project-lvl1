package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Even {
    /**
     * Even game class.
     */
    public static void evenGame() {
        final int maxRandom = 49;
        final int minRandom = 1;
        final int numberOfTries = 3;
        int counterOfCorrect = 0;
        Random randomNum = new Random();
        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
        for (int i = 0; i < numberOfTries; i++) {
            int showRandomNum = minRandom + randomNum.nextInt(maxRandom);
            System.out.println("Question : " + showRandomNum);
            Scanner setAnswer = new Scanner(System.in);
            System.out.print("Your answer: ");
            String answer = setAnswer.nextLine();
            if ((showRandomNum % 2 == 0 && answer.equals("yes"))
                    || (showRandomNum % 2 == 1 && answer.equals("no"))) {
                System.out.println("Correct!");
                counterOfCorrect++;
            } else {
                String correctAnswer = "";
                switch (showRandomNum % 2) {
                    case 0: {
                        correctAnswer = "yes";
                        break;
                    }
                    case 1: {
                        correctAnswer = "no";
                        break;
                    }
                    default: {
                        System.out.println("ERROR -1");
                    }
                }
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was "
                        + "'" + correctAnswer + "'.");
                System.out.println("Let's try again, " + Cli.getSayMyNameSong() + "!");
            }
        }
        if (counterOfCorrect == numberOfTries) {
            System.out.println("Congratulations, " + Cli.getSayMyNameSong() + "!");
        }
    }
}
