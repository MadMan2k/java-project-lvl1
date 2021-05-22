package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    /**
     * Even game class.
     */
    public static void evenGame() {
        int counterOfCorrect = 0;
        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
        for (int i = 0; i < Engine.getNumberOfTries(); i++) {
            int[] showRandomNum = Engine.showRandomNum();
            Engine.printQuestion();
            System.out.println(showRandomNum[0]);
            String answer = Engine.stringYourAnswer();
            if ((showRandomNum[0] % 2 == 0 && answer.equals("yes"))
                    || (showRandomNum[0] % 2 == 1 && answer.equals("no"))) {
                Engine.printCorrect();
                counterOfCorrect++;
            } else {
                String correctAnswer = "";
                switch (showRandomNum[0] % 2) {
                    case 0:
                        correctAnswer = "yes";
                        break;
                    case 1:
                        correctAnswer = "no";
                        break;
                    default:
                        Engine.printError();
                }
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was "
                        + "'" + correctAnswer + "'.");
                Engine.printLetsTryAgain();
                break;
            }
        }
        if (counterOfCorrect == Engine.getNumberOfTries()) {
            Engine.printCongartulations();
        }
    }
}
