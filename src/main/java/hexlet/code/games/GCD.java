package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {
    private static final String RULES = "Find the greatest common divisor of given numbers.";

    public static void gcdGame() {
        System.out.println(RULES);
        for (int i = 0; i < Engine.getNumberOfTries(); i++) {
            int[] randomNumArray = Engine.showRandomNum();
            Engine.printQuestion();
            System.out.println(randomNumArray[0] + " " + randomNumArray[1]);
            int answer = Engine.intYourAnswer();
            String gcdByEuclidString = String.valueOf(gcdByEuclid(randomNumArray[0], randomNumArray[1]));
            String answerString = String.valueOf(answer);
            if (!Engine.verifyAnswer(gcdByEuclidString, answerString)) {
                break;
            }
        }
        Engine.doWeHaveAWinner(Engine.getCounterOfCorrectAnswers(), Engine.getNumberOfTries());
    }

    public static int gcdByEuclid(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return gcdByEuclid(num2, num1 % num2);
    }
}
