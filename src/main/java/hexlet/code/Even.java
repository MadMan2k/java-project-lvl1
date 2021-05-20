package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public final class Even {
    /**
     * Even game class.
     */
    public static void evenGame() {
        final int maxRandom = 999;
        final int minRandom = 1;
        final int numberOfQuestions = 3;
        Random randomNum = new Random();
        int[] showRandomNum = new int[numberOfQuestions];
        showRandomNum[0] = minRandom + randomNum.nextInt(maxRandom);
        showRandomNum[1] = minRandom + randomNum.nextInt(maxRandom);
        showRandomNum[2] = minRandom + randomNum.nextInt(maxRandom);
        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
        for (int i = 0; i < showRandomNum.length; i++) {
            System.out.println("Question : " + showRandomNum[i]);
            Scanner setAnswer = new Scanner(System.in);
            System.out.print("Your answer: ");
            String answer = setAnswer.nextLine();
            if ((showRandomNum[i] % 2 == 0 && answer.equals("yes")) ||
                    (showRandomNum[i] % 2 != 0 && answer.equals("no"))) {
                System.out.println("Correct!");
                if (i == 2) {
                    System.out.println("Congratulations, " + Cli.getSayMyNameSong() + "!");
                } else {
                    continue;
                }

            }
            if (showRandomNum[i] % 2 != 0 && !answer.equals("no")) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was 'no'.");
                System.out.println("Let's try again, " + Cli.getSayMyNameSong() + "!");
                break;
            }
            if (showRandomNum[i] % 2 == 0 && !answer.equals("yes")) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was 'yes'.");
                System.out.println("Let's try again, " + Cli.getSayMyNameSong() + "!");
                break;
            }
        }
    }
}
