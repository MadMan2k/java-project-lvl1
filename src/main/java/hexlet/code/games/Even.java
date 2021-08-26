package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    private static final String RULES = "Answer 'yes' if number even otherwise answer 'no'.";
    public static void evenGame() {
        String[] gameQuestions = new String[Engine.NUMBER_OF_TRIES];
        String[] rightAnswers = new String[Engine.NUMBER_OF_TRIES];
        int[] randomNums = Utils.getRandomNumsArray(Engine.NUMBER_OF_TRIES);
        for (int j = 0; j < gameQuestions.length; j++) {
            gameQuestions[j] = String.valueOf(randomNums[j]);
        }
        for (int k = 0; k < rightAnswers.length; k++) {
            rightAnswers[k] = checkRightAnswer(randomNums[k]);
        }
        Engine.runGame(RULES, gameQuestions, rightAnswers);
    }

    private static String checkRightAnswer(int randomNum) {
        String rightAnswer;
        if (randomNum % 2 == 0) {
            rightAnswer = Engine.YES_TEXT;
        } else {
            rightAnswer = Engine.NO_TEXT;
        }
        return rightAnswer;
    }
}
