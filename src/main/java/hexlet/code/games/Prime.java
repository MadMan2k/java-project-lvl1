package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    private static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    public static void primeGame() {
        String[] gameQuestions = new String[Engine.NUMBER_OF_TRIES];
        String[] rightAnswers = new String[Engine.NUMBER_OF_TRIES];
        final int threeIsNotMagicNumber = 3;
        int[] randomNums = getRandomNums(Engine.NUMBER_OF_TRIES);
        for (int i = 0; i < Engine.NUMBER_OF_TRIES; i++) {
            gameQuestions[i] = String.valueOf(randomNums[i]);
            if (randomNums[i] == 0 || randomNums[i] == 1) {
                rightAnswers[i] = Engine.NO_TEXT;
            }
            if (randomNums[i] == 2 || randomNums[i] == threeIsNotMagicNumber) {
                rightAnswers[i] = Engine.YES_TEXT;
            }
            for (int k = 2; k <= randomNums[i] / 2; k++) {
                if ((randomNums[i] % k) == 0) {
                    rightAnswers[i] = Engine.NO_TEXT;
                    break;
                } else {
                    rightAnswers[i] = Engine.YES_TEXT;
                }
            }
        }
        Engine.runGame(RULES, gameQuestions, rightAnswers);
    }

    private static int[] getRandomNums(int numberOfValues) {
        int[] randomNums = new int[numberOfValues];
        for (int i = 0; i < randomNums.length; i++) {
            randomNums[i] = Engine.getRandomNum().nextInt(Engine.getMaxRandom());
        }
        return randomNums;
    }
}
