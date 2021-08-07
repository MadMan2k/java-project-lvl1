package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;

public class Progression {
    private static final String RULES = "What number is missing in the progression?";

//    public static void progressionGame() {
//        final int progressionSize = 10;
//        final int maxCommonDifference = 10;
//        int[] progression = new int[progressionSize];
//
//        System.out.println(RULES);
//        for (int i = 0; i < Engine.getNumberOfTries(); i++) {
//            int startNumOfProgression = Engine.getRandomNum().nextInt(Engine.getMaxRandom());
//            int commonDifference = Engine.getRandomNum().nextInt(maxCommonDifference);
//            int indexOfHiddenNum = Engine.getRandomNum().nextInt(progressionSize);
//            for (int k = 0; k < progressionSize; k++) {
//                if (k == 0) {
//                    progression[k] = startNumOfProgression;
//                } else {
//                    progression[k] = progression[k - 1] + commonDifference;
//                }
//            }
//            int[] progressionBeforeHidden = Arrays.copyOfRange(progression, 0, indexOfHiddenNum);
//            int[] progressionAfterHidden = Arrays.copyOfRange(progression, indexOfHiddenNum + 1, progressionSize);
//            Engine.printQuestion();
//            for (int m = 0; m < indexOfHiddenNum; m++) {
//                System.out.print(progressionBeforeHidden[m] + " ");
//            }
//            if (indexOfHiddenNum == progressionSize - 1) {
//                System.out.println("..");
//            } else {
//                System.out.print(".. ");
//            }
//            for (int n = 0; n < progressionSize - indexOfHiddenNum - 1; n++) {
//                if (n == progressionSize - indexOfHiddenNum - 2) {
//                    System.out.println(progressionAfterHidden[n]);
//                } else {
//                    System.out.print(progressionAfterHidden[n] + " ");
//                }
//            }
//            System.out.println();
//            int answer = Engine.intYourAnswer();
//            String progressionString = String.valueOf(progression[indexOfHiddenNum]);
//            String answerString = String.valueOf(answer);
//            if (!Engine.verifyAnswer(progressionString, answerString)) {
//                break;
//            }
//        }
//        Engine.doWeHaveAWinner(Engine.getCounterOfCorrectAnswers(), Engine.getNumberOfTries());
//    }
//public static void main(String[] args) {
//    progressionGame();
//}
    

    public static void progressionGame() {
        String[] gameQuestions = new String[Engine.getNumberOfTries()];
        String[] rightAnswers = new String[Engine.getNumberOfTries()];
        final int progressionSize = 10;
        final int maxCommonDifference = 10;
        int[] progression = new int[progressionSize];
        for (int i = 0; i < Engine.getNumberOfTries(); i++) {
            int startNumOfProgression = Engine.getRandomNum().nextInt(Engine.getMaxRandom());
            int commonDifference = Engine.getRandomNum().nextInt(maxCommonDifference);
            int indexOfHiddenNum = Engine.getRandomNum().nextInt(progressionSize);
            for (int k = 0; k < progressionSize; k++) {
                if (k == 0) {
                    progression[k] = startNumOfProgression;
                } else {
                    progression[k] = progression[k - 1] + commonDifference;
                }
            }
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
        Engine.gameCore(RULES, gameQuestions, rightAnswers);
    }
}
