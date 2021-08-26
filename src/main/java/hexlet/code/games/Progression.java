package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Arrays;

public class Progression {
    private static final String RULES = "What number is missing in the progression?";
    public static void progressionGame() {
        String[] gameQuestions = new String[Engine.NUMBER_OF_TRIES];
        String[] rightAnswers = new String[Engine.NUMBER_OF_TRIES];
        final int progressionSize = 10;
        for (int i = 0; i < Engine.NUMBER_OF_TRIES; i++) {
            int indexOfHiddenNum = Utils.getRandomNum(progressionSize);
            int[] progression = getProgression(progressionSize);
            String[] progressionString = new String[progressionSize];
            for (int j = 0; j < progressionSize; j++) {
                progressionString[j] = String.valueOf(progression[j]);
            }
            progressionString[indexOfHiddenNum] = "..";
            for (int k = 0; k < progressionSize; k++) {
                if (k == 0) {
                    gameQuestions[i] = progressionString[k];
                } else {
                    gameQuestions[i] = gameQuestions[i] + " " + progressionString[k];
                }
            }
            rightAnswers[i] = String.valueOf(progression[indexOfHiddenNum]);
        }
        Engine.runGame(RULES, gameQuestions, rightAnswers);
    }

//        for (int i = 0; i < Engine.NUMBER_OF_TRIES; i++) {
//            int indexOfHiddenNum = Utils.getRandomNum(progressionSize);
//            int[] progression = getProgression(progressionSize);
//            int[] progressionBeforeHidden = Arrays.copyOfRange(progression, 0, indexOfHiddenNum);
//            int[] progressionAfterHidden = Arrays.copyOfRange(progression, indexOfHiddenNum + 1, progressionSize);
//            gameQuestions[i] = getQuestionPartBeforeHidden(indexOfHiddenNum, progressionBeforeHidden)
//            + getHiddenPart(indexOfHiddenNum, progressionSize)
//                    + getQuestionPartAfterHidden(progressionSize, indexOfHiddenNum, progressionAfterHidden);
//            rightAnswers[i] = String.valueOf(progression[indexOfHiddenNum]);
//        }
//        Engine.runGame(RULES, gameQuestions, rightAnswers);
//    }

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

//    private static String getQuestionPartBeforeHidden(int indexOfHiddenNum, int[] progressionBeforeHidden) {
//        String questionPartBeforeHidden = "";
//        for (int m = 0; m < indexOfHiddenNum; m++) {
//            if (m == 0) {
//                questionPartBeforeHidden = String.valueOf(progressionBeforeHidden[m]) + " ";
//            } else {
//                questionPartBeforeHidden = questionPartBeforeHidden
//                + String.valueOf(progressionBeforeHidden[m]) + " ";
//            }
//        }
//        return questionPartBeforeHidden;
//    }
//
//    private static String getHiddenPart(int indexOfHiddenNum, int progressionSize) {
//        String hiddenPart = "";
//        if (indexOfHiddenNum == progressionSize - 1) {
//            hiddenPart = "..";
//        } else {
//            hiddenPart = ".. ";
//        }
//        return hiddenPart;
//    }
//
//    private static String getQuestionPartAfterHidden(int progressionSize, int indexOfHiddenNum,
//                                                     int[] progressionAfterHidden) {
//        String questionPartAfterHidden = "";
//        for (int n = 0; n < progressionSize - indexOfHiddenNum - 1; n++) {
//            if (n == progressionSize - indexOfHiddenNum - 2) {
//                questionPartAfterHidden = questionPartAfterHidden + String.valueOf(progressionAfterHidden[n]);
//            } else {
//                questionPartAfterHidden = questionPartAfterHidden + String.valueOf(progressionAfterHidden[n]) + " ";
//            }
//        }
//        return questionPartAfterHidden;
//    }
}
