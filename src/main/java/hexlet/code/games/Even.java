package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    private static final String RULES = "Answer 'yes' if number even otherwise answer 'no'.";
    public static void evenGame() {
        String[] gameQuestions = new String[Engine.NUMBER_OF_TRIES];
        String[] rightAnswers = new String[Engine.NUMBER_OF_TRIES];
        for (int i = 0; i < Engine.NUMBER_OF_TRIES; i++) {
            int randomNum = Utils.getRandomNumWithMax(Utils.MAX_OF_RANDOM);
            gameQuestions[i] = String.valueOf(randomNum);
            rightAnswers[i] = checkRightAnswer(randomNum);

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
