package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    private static final String RULES = "What number is missing in the progression?";
    private static final int PROGRESSION_SIZE = 10;

    public static void progressionGame() {
        final int maxCommonDifference = 10;
        String[] gameQuestions = new String[Engine.NUMBER_OF_TRIES];
        String[] rightAnswers = new String[Engine.NUMBER_OF_TRIES];
        for (int i = 0; i < Engine.NUMBER_OF_TRIES; i++) {
            int indexOfHiddenNum = Utils.getRandomNum(PROGRESSION_SIZE);
            int startNumOfProgression = Utils.getRandomNum(Utils.MAX_OF_RANDOM);
            int commonDifference = Utils.getRandomNum(maxCommonDifference);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < PROGRESSION_SIZE; j++) {
                if (j == indexOfHiddenNum) {
                    sb.append(".. ");
                    rightAnswers[i] = String.valueOf(startNumOfProgression + (commonDifference * j));
                } else {
                    sb.append(startNumOfProgression + (commonDifference * j)).append(" ");
                }
            }
            gameQuestions[i] = sb.toString();
        }
        Engine.runGame(RULES, gameQuestions, rightAnswers);
    }
}
