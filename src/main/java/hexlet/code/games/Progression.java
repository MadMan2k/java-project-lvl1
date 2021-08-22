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
            int indexOfHiddenNum = Engine.getRandomNumWithMax(progressionSize);
            int[] progression = getProgression(progressionSize);
            int[] progressionBeforeHidden = Arrays.copyOfRange(progression, 0, indexOfHiddenNum);
            int[] progressionAfterHidden = Arrays.copyOfRange(progression, indexOfHiddenNum + 1, progressionSize);
            gameQuestions[i] = getQuestionPartBeforeHidden(indexOfHiddenNum, progressionBeforeHidden)
            + getHiddenPart(indexOfHiddenNum, progressionSize)
                    + getQuestionPartAfterHidden(progressionSize, indexOfHiddenNum, progressionAfterHidden);
//            for (int m = 0; m < indexOfHiddenNum; m++) {
//                if (m == 0) {
//                    gameQuestions[i] = String.valueOf(progressionBeforeHidden[m]) + " ";
//                } else {
//                    gameQuestions[i] = gameQuestions[i] + String.valueOf(progressionBeforeHidden[m]) + " ";
//                }
//            }

//            if (indexOfHiddenNum == progressionSize - 1) {
//                gameQuestions[i] = gameQuestions[i] + "..";
//            } else if (indexOfHiddenNum == 0) {
//                gameQuestions[i] = ".. ";
//            } else {
//                gameQuestions[i] = gameQuestions[i] + ".. ";
//            }

//            for (int n = 0; n < progressionSize - indexOfHiddenNum - 1; n++) {
//                if (n == progressionSize - indexOfHiddenNum - 2) {
//                    gameQuestions[i] = gameQuestions[i] + String.valueOf(progressionAfterHidden[n]);
//                } else {
//                    gameQuestions[i] = gameQuestions[i] + String.valueOf(progressionAfterHidden[n]) + " ";
//                }
//            }

            rightAnswers[i] = String.valueOf(progression[indexOfHiddenNum]);
        }
        Engine.runGame(RULES, gameQuestions, rightAnswers);
    }

    private static int[] getProgression(int numberOfValues) {
        int[] progression = new int[numberOfValues];
        int startNumOfProgression = Engine.getRandomNumWithMax(Engine.getMaxRandom());
        final int maxCommonDifference = 10;
        int commonDifference = Engine.getRandomNumWithMax(maxCommonDifference);
        for (int k = 0; k < numberOfValues; k++) {
            if (k == 0) {
                progression[k] = startNumOfProgression;
            } else {
                progression[k] = progression[k - 1] + commonDifference;
            }
        }
        return progression;
    }

    private static String getQuestionPartBeforeHidden(int indexOfHiddenNum, int[] progressionBeforeHidden) {
        String questionPartBeforeHidden = "";
        for (int m = 0; m < indexOfHiddenNum; m++) {
            if (m == 0) {
                questionPartBeforeHidden = String.valueOf(progressionBeforeHidden[m]) + " ";
            } else {
                questionPartBeforeHidden = questionPartBeforeHidden + String.valueOf(progressionBeforeHidden[m]) + " ";
            }
        }
        return questionPartBeforeHidden;
    }

    private static String getHiddenPart(int indexOfHiddenNum, int progressionSize) {
        String hiddenPart = "";
        if (indexOfHiddenNum == progressionSize - 1) {
            hiddenPart = "..";
        } else {
            hiddenPart = ".. ";
        }
        return hiddenPart;
    }

    private static String getQuestionPartAfterHidden(int progressionSize, int indexOfHiddenNum,
                                                     int[] progressionAfterHidden) {
        String questionPartAfterHidden = "";
        for (int n = 0; n < progressionSize - indexOfHiddenNum - 1; n++) {
            if (n == progressionSize - indexOfHiddenNum - 2) {
                questionPartAfterHidden = questionPartAfterHidden + String.valueOf(progressionAfterHidden[n]);
            } else {
                questionPartAfterHidden = questionPartAfterHidden + String.valueOf(progressionAfterHidden[n]) + " ";
            }
        }
        return questionPartAfterHidden;
    }
}
