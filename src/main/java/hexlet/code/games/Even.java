package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    private static final String RULES = "Answer 'yes' if number even otherwise answer 'no'.";
    public static void evenGame() {
        String[] gameQuestions = new String[Engine.NUMBER_OF_TRIES];
        String[] rightAnswers = new String[Engine.NUMBER_OF_TRIES];
        for (int i = 0; i < Engine.NUMBER_OF_TRIES; i++) {
            int randomNum = Utils.getRandomNum(Utils.MAX_OF_RANDOM);
            gameQuestions[i] = String.valueOf(randomNum);
            rightAnswers[i] = getRightAnswer(randomNum);
        }
        Engine.runGame(RULES, gameQuestions, rightAnswers);
    }

    private static String getRightAnswer(int randomNum) {
        return randomNum % 2 == 0 ? Engine.YES_TEXT : Engine.NO_TEXT;
    }
}
