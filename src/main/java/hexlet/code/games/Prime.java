package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    private static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int THREE_IS_NOT_MAGIC_NUMBER = 3;
    public static void primeGame() {
        String[] gameQuestions = new String[Engine.NUMBER_OF_TRIES];
        String[] rightAnswers = new String[Engine.NUMBER_OF_TRIES];
        for (int i = 0; i < Engine.NUMBER_OF_TRIES; i++) {
            int randomNum = Utils.getRandomNum(Utils.MAX_OF_RANDOM);
            gameQuestions[i] = String.valueOf(randomNum);
            rightAnswers[i] = checkRightAnswer(randomNum);
        }
        Engine.runGame(RULES, gameQuestions, rightAnswers);
    }

    private static String checkRightAnswer(int randomNum) {
        String rightAnswer = "";
        if (randomNum == 0 || randomNum == 1) {
            rightAnswer = Engine.NO_TEXT;
        }
        if (randomNum == 2 || randomNum == THREE_IS_NOT_MAGIC_NUMBER) {
            rightAnswer = Engine.YES_TEXT;
        }
        for (int k = 2; k <= randomNum / 2; k++) {
            if ((randomNum % k) == 0) {
                rightAnswer = Engine.NO_TEXT;
                break;
            } else {
                rightAnswer = Engine.YES_TEXT;
            }
        }
        return rightAnswer;
    }
}
