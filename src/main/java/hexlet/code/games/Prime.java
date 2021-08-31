package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    private static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    public static void primeGame() {
        String[] gameQuestions = new String[Engine.NUMBER_OF_TRIES];
        String[] rightAnswers = new String[Engine.NUMBER_OF_TRIES];
        for (int i = 0; i < Engine.NUMBER_OF_TRIES; i++) {
            int randomNum = Utils.getRandomNum(Utils.MAX_OF_RANDOM);
            gameQuestions[i] = String.valueOf(randomNum);
            rightAnswers[i] = isPrimeNumber(randomNum) ? Engine.YES_TEXT : Engine.NO_TEXT;
        }
        Engine.runGame(RULES, gameQuestions, rightAnswers);
    }

    private static boolean isPrimeNumber(int randomNum) {
        if (randomNum < 2) {
            return false;
        }
        for (int k = 2; k <= Math.sqrt(randomNum); k++) {
            if ((randomNum % k) == 0) {
                return false;
            }
        }
        return true;
    }
}
