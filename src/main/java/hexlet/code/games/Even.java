package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    private static final String RULES = "Answer 'yes' if number even otherwise answer 'no'.";
    public static void evenGame() {
        String[] gameQuestions = new String[Engine.NUMBER_OF_TRIES];
        String[] rightAnswers = new String[Engine.NUMBER_OF_TRIES];
        int[] randomNums = getRandomNums(Engine.NUMBER_OF_TRIES);
        for (int j = 0; j < gameQuestions.length; j++) {
            gameQuestions[j] = String.valueOf(randomNums[j]);
        }
        for (int k = 0; k < rightAnswers.length; k++) {
            switch (randomNums[k] % 2) {
                case 0:
                    rightAnswers[k] = Engine.YES_TEXT;
                    break;
                case 1:
                    rightAnswers[k] = Engine.NO_TEXT;
                    break;
                default:
                    Engine.printError();
            }
        }
        Engine.runGame(RULES, gameQuestions, rightAnswers);
    }

    private static int[] getRandomNums(int numberOfValues) {
        int[] randomNums = new int[numberOfValues];
        for (int i = 0; i < randomNums.length; i++) {
            randomNums[i] = Engine.getRandomNumWithMax(Engine.getMaxRandom());
        }
        return randomNums;
    }
}
