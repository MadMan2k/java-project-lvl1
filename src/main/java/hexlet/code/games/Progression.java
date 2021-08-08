package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;

public class Progression {
    private static final String RULES = "What number is missing in the progression?";
    public static void progressionGame() {
        String[] gameQuestions = new String[Engine.NUMBER_OF_TRIES];
        String[] rightAnswers = new String[Engine.NUMBER_OF_TRIES];
        final int progressionSize = 10;
        for (int i = 0; i < Engine.NUMBER_OF_TRIES; i++) {
            int indexOfHiddenNum = Engine.getRandomNum().nextInt(progressionSize);
            int[] progression = getProgression(progressionSize);
            int[] progressionBeforeHidden = Arrays.copyOfRange(progression, 0, indexOfHiddenNum);
            int[] progressionAfterHidden = Arrays.copyOfRange(progression, indexOfHiddenNum + 1, progressionSize);
            for (int m = 0; m < indexOfHiddenNum; m++) {
                if (m == 0) {
                    gameQuestions[i] = String.valueOf(progressionBeforeHidden[m]) + " ";
                } else {
                    gameQuestions[i] = gameQuestions[i] + String.valueOf(progressionBeforeHidden[m]) + " ";
                }
            }
            if (indexOfHiddenNum == progressionSize - 1) {
                gameQuestions[i] = gameQuestions[i] + "..";
            } else if (indexOfHiddenNum == 0) {
                gameQuestions[i] = ".. ";
            } else {
                gameQuestions[i] = gameQuestions[i] + ".. ";
            }
            for (int n = 0; n < progressionSize - indexOfHiddenNum - 1; n++) {
                if (n == progressionSize - indexOfHiddenNum - 2) {
                    gameQuestions[i] = gameQuestions[i] + String.valueOf(progressionAfterHidden[n]);
                } else {
                    gameQuestions[i] = gameQuestions[i] + String.valueOf(progressionAfterHidden[n]) + " ";
                }
            }
            rightAnswers[i] = String.valueOf(progression[indexOfHiddenNum]);
        }
        Engine.runGame(RULES, gameQuestions, rightAnswers);
    }

    private static int[] getProgression(int numberOfValues) {
        int[] progression = new int[numberOfValues];
        int startNumOfProgression = Engine.getRandomNum().nextInt(Engine.getMaxRandom());
        final int maxCommonDifference = 10;
        int commonDifference = Engine.getRandomNum().nextInt(maxCommonDifference);
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
