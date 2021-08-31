package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    private static final String RULES = "What number is missing in the progression?";
    private static final int PROGRESSION_SIZE = 10;
    private static final int MAX_STEP = 10;

    public static void progressionGame() {
        String[] gameQuestions = new String[Engine.NUMBER_OF_TRIES];
        String[] rightAnswers = new String[Engine.NUMBER_OF_TRIES];
        for (int i = 0; i < Engine.NUMBER_OF_TRIES; i++) {
            int indexOfHiddenNum = Utils.getRandomNum(PROGRESSION_SIZE);
            int startNumOfProgression = Utils.getRandomNum(Utils.MAX_OF_RANDOM);
            int step = Utils.getRandomNum(MAX_STEP);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < PROGRESSION_SIZE; j++) {
                if (j == indexOfHiddenNum) {
                    sb.append(".. ");
                    rightAnswers[i] = String.valueOf(startNumOfProgression + (step * j));
                } else {
                    sb.append(startNumOfProgression + (step * j)).append(" ");
                }
            }
            gameQuestions[i] = sb.toString();
        }
        Engine.runGame(RULES, gameQuestions, rightAnswers);
    }
}
