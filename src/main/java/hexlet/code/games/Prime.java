package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    private static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    public static void primeGame() {
        String[] gameQuestions = new String[Engine.NUMBER_OF_TRIES];
        String[] rightAnswers = new String[Engine.NUMBER_OF_TRIES];
        final int threeIsNotMagicNumber = 3;
        int[] randomNums = Engine.getRandomNumsArray(Engine.NUMBER_OF_TRIES);
        for (int i = 0; i < Engine.NUMBER_OF_TRIES; i++) {
            gameQuestions[i] = String.valueOf(randomNums[i]);
            if (randomNums[i] == 0 || randomNums[i] == 1) {
                rightAnswers[i] = Engine.NO_TEXT;
            }
            if (randomNums[i] == 2 || randomNums[i] == threeIsNotMagicNumber) {
                rightAnswers[i] = Engine.YES_TEXT;
            }
            rightAnswers[i] = checkRightAnswer(randomNums[i]);
        }
        Engine.runGame(RULES, gameQuestions, rightAnswers);
    }

    private static String checkRightAnswer(int randomNum) {
        String rightAnswer = "";
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
