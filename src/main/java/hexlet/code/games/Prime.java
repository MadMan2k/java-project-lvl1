package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {

    public static void primeGame() {
        String resultString = "";
        String rules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        System.out.println(rules);
        final int threeIsNotMagicNumber = 3;

            for (int i = 0; i < Engine.getNumberOfTries(); i++) {
            int randomNum = Engine.getRandomNum().nextInt(Engine.getMaxRandom());
            Engine.printQuestion();
            System.out.println(randomNum);
            if (randomNum == 0 || randomNum == 1) {
                resultString = "no";
            }
            if (randomNum == 2 || randomNum == threeIsNotMagicNumber) {
                resultString = "yes";
            }
            for (int k = 2; k <= randomNum / 2; k++) {
                if ((randomNum % k) == 0) {
                    resultString = "no";
                    break;
                } else {
                    resultString = "yes";
                }
            }
            String answer = Engine.stringYourAnswer();
            if (!Engine.verifyAnswerString(resultString, answer)) {
                break;
            }
        }
        Engine.doWeHaveAWinner(Engine.getCounterOfCorrectAnswers(), Engine.getNumberOfTries());
    }
}
