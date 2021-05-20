package hexlet.code;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Even {
//    /**
//     * START TEMP MAIN
//     */
//    public static void main(String[] args) {
//        evenGame();
//    }
//    /**
//     * END TEMP MAIN
//     */

    public static void evenGame() {
        int maxRandom = 999;
        int minRandom = 1;
        Random randomNum = new Random();
        int[] showRandomNum = new int[3];
        showRandomNum[0] = minRandom + randomNum.nextInt(maxRandom);
        showRandomNum[1] = minRandom + randomNum.nextInt(maxRandom);
        showRandomNum[2] = minRandom + randomNum.nextInt(maxRandom);
        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
        for (int i = 0; i < 3; i++) {
            System.out.println("Question : " + showRandomNum[i]);
            Scanner setAnswer = new Scanner(System.in);
            System.out.print("Your answer: ");
            String answer = setAnswer.nextLine();
            if ((showRandomNum[i] % 2 == 0 && answer.equals("yes")) || (showRandomNum[i] % 2 != 0 && answer.equals("no"))) {
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