package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    private static final String RULES = "Find the greatest common divisor of given numbers.";
    public static void gcdGame() {
        String[] gameQuestions = new String[Engine.NUMBER_OF_TRIES];
        String[] rightAnswers = new String[Engine.NUMBER_OF_TRIES];
        for (int i = 0; i < Engine.NUMBER_OF_TRIES; i++) {
            int firstRandomNum = Utils.MIN_OF_RANDOM + Utils.getRandomNum(Utils.MAX_OF_RANDOM);
            int secondRandomNum = Utils.MIN_OF_RANDOM + Utils.getRandomNum(Utils.MAX_OF_RANDOM);
            gameQuestions[i] = String.format("%s %s", firstRandomNum, secondRandomNum);
            rightAnswers[i] = String.valueOf(gcdByEuclid(firstRandomNum, secondRandomNum));
        }

        Engine.runGame(RULES, gameQuestions, rightAnswers);
    }

    public static int gcdByEuclid(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return gcdByEuclid(num2, num1 % num2);
    }
}
