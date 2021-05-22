package hexlet.code.games;

import hexlet.code.Cli;

import java.util.Random;
import java.util.Scanner;

public class Calc {
    public static void calcGame() {
        final String question = "Question : ";
        final int maxRandom = 49;
        final int minRandom = 1;
        final int numberOfTries = 3;
        final int numberOfOperators = 3;
        int resultInt = 0;
        int counterOfCorrect = 0;
        Random randomNum = new Random();
        int[] showRandomNum = new int[2];
        System.out.println("What is the result of the expression?");
        for (int i = 0; i < numberOfTries; i++) {
            showRandomNum[0] = minRandom + randomNum.nextInt(maxRandom);
            showRandomNum[1] = minRandom + randomNum.nextInt(maxRandom);
            int showRandomOperator = randomNum.nextInt(numberOfOperators);
            switch (showRandomOperator) {   // 0 ==> sum ; 1 ==> subtraction ; 2 ==>  product ; default ==> error
                case 0:
                    resultInt = showRandomNum[0] + showRandomNum[1];
                    System.out.println(question + showRandomNum[0] + " + " + showRandomNum[1]);
                    break;
                case 1:
                    resultInt = showRandomNum[0] - showRandomNum[1];
                    System.out.println(question + showRandomNum[0] + " - " + showRandomNum[1]);
                    break;
                case 2:
                    resultInt = showRandomNum[0] * showRandomNum[1];
                    System.out.println(question + showRandomNum[0] + " * " + showRandomNum[1]);
                    break;
                default :
                    System.out.println("Error -1");
            }
            System.out.print("Your answer: ");
            Scanner setAnswer = new Scanner(System.in);
            int answer = Integer.parseInt(setAnswer.nextLine());
            if (resultInt == answer) {
                System.out.println("Correct!");
                counterOfCorrect++;
            } else {
                System.out.println("'" + answer + "'" + " is wrong answer ;(. Correct answer was "
                        + "'" + resultInt + "'");
                System.out.println("Let's try again, " + Cli.getSayMyNameSong() + "!");
                break;
            }
        }
        if (counterOfCorrect == numberOfTries) {
            System.out.println("Congratulations, " + Cli.getSayMyNameSong() + "!");
        }
    }
}
