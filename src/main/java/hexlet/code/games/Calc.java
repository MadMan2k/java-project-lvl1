package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Calc {
    public static void calcGame() {
        int resultInt = 0;
        int counterOfCorrect = 0;

        System.out.println("What is the result of the expression?");
        for (int i = 0; i < Engine.getNumberOfTries(); i++) {
            int[] showRandomNum = Engine.showRandomNum();
            int showRandomOperator = Engine.getRandomNum().nextInt(Engine.getNumberOfOperators());
            switch (showRandomOperator) {   // 0 ==> sum ; 1 ==> subtraction ; 2 ==>  product ; default ==> error
                case 0:
                    resultInt = showRandomNum[0] + showRandomNum[1];
                    Engine.printQuestion();
                    System.out.println(showRandomNum[0] + " + " + showRandomNum[1]);
                    break;
                case 1:
                    resultInt = showRandomNum[0] - showRandomNum[1];
                    Engine.printQuestion();
                    System.out.println(showRandomNum[0] + " - " + showRandomNum[1]);
                    break;
                case 2: // The difficulty decreased to one-fifth of its original level for easier game
                    resultInt = (showRandomNum[0] / 5) * (showRandomNum[1] / 5);
                    Engine.printQuestion();
                    System.out.println((showRandomNum[0] / 5) + " * " + (showRandomNum[1] / 5));
                    break;
                default :
                    Engine.printError();
            }
            int answer = Engine.intYourAnswer();
            if (resultInt == answer) {
                Engine.printCorrect();
                counterOfCorrect++;
            } else {
                System.out.println("'" + answer + "'" + " is wrong answer ;(. Correct answer was "
                        + "'" + resultInt + "'");
                Engine.printLetsTryAgain();
                break;
            }
        }
        if (counterOfCorrect == Engine.getNumberOfTries()) {
            Engine.printCongartulations();
        }
    }
}
