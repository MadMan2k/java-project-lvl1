package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    private static final String RULES = "What number is missing in the progression?";
    private static final int PROGRESSION_SIZE = 10;
    public static void progressionGame() {
        String[] gameQuestions = new String[Engine.NUMBER_OF_TRIES];
        String[] rightAnswers = new String[Engine.NUMBER_OF_TRIES];
        for (int i = 0; i < Engine.NUMBER_OF_TRIES; i++) {
            int indexOfHiddenNum = Utils.getRandomNum(PROGRESSION_SIZE);
            int[] progression = getProgression(PROGRESSION_SIZE);
            gameQuestions[i] = getGameQuestion(progression, indexOfHiddenNum);
            rightAnswers[i] = String.valueOf(progression[indexOfHiddenNum]);
        }
        Engine.runGame(RULES, gameQuestions, rightAnswers);
    }

    public static String getGameQuestion(int[] progression, int indexOfHiddenNum) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < progression.length; i++) {
            if (i == indexOfHiddenNum) {
                sb.append(".. ");
            } else {
                sb.append(progression[i]).append(" ");
            }
        }
        return sb.substring(0, sb.length() - 1);
    }

    private static int[] getProgression(int numberOfValues) {
        int[] progression = new int[numberOfValues];
        int startNumOfProgression = Utils.getRandomNum(Utils.MAX_OF_RANDOM);
        final int maxCommonDifference = 10;
        int commonDifference = Utils.getRandomNum(maxCommonDifference);
        for (int k = 0; k < numberOfValues; k++) {
            if (k == 0) {
                progression[k] = startNumOfProgression;
            } else {
                progression[k] = progression[k - 1] + commonDifference;
            }
        }
        return progression;
    }

}
