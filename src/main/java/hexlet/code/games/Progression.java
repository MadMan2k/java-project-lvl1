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
//            String[] progressionString = new String[progressionSize];
//            for (int j = 0; j < progressionSize; j++) {
//                progressionString[j] = String.valueOf(progression[j]);
//            }
//            progressionString[indexOfHiddenNum] = "..";
//            for (int k = 0; k < progressionSize; k++) {
//                if (k == 0) {
//                    gameQuestions[i] = progressionString[k];
//                } else {
//                    gameQuestions[i] = gameQuestions[i] + " " + progressionString[k];
//                }
//            }
            rightAnswers[i] = String.valueOf(progression[indexOfHiddenNum]);
        }
        Engine.runGame(RULES, gameQuestions, rightAnswers);
    }

    public static String getGameQuestion(int[] progression, int indexOfHiddenNum) {
        StringBuilder gameQuestion = new StringBuilder();
        String[] progressionString = new String[PROGRESSION_SIZE];
        for (int j = 0; j < PROGRESSION_SIZE; j++) {
            progressionString[j] = String.valueOf(progression[j]);
        }
        progressionString[indexOfHiddenNum] = "..";
        for (int k = 0; k < PROGRESSION_SIZE; k++) {
            if (k == 0) {
                gameQuestion = new StringBuilder(progressionString[k]);
            } else {
                gameQuestion.append(" ").append(progressionString[k]);
            }
        }

        return gameQuestion.toString();
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
