package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {

    public static void gcdGame() {
        Engine.printRules("gcd");
        for (int i = 0; i < Engine.getNumberOfTries(); i++) {
            int[] showRandomNum = Engine.showRandomNum();
            Engine.printQuestion();
            System.out.println(showRandomNum[0] + " " + showRandomNum[1]);
            int answer = Engine.intYourAnswer();
            if (!Engine.verifyAnswerInt(gcdByEuclid(showRandomNum[0], showRandomNum[1]), answer)) {
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
