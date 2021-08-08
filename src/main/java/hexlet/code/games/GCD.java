package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {
    private static final String RULES = "Find the greatest common divisor of given numbers.";

//    public static void gcdGame() {
//        System.out.println(RULES);
//        for (int i = 0; i < Engine.getNumberOfTries(); i++) {
//            int[] randomNumArray = Engine.showRandomNumArray();
//            Engine.printQuestion();
//            System.out.println(randomNumArray[0] + " " + randomNumArray[1]);
//            int answer = Engine.intYourAnswer();
//            String gcdByEuclidString = String.valueOf(gcdByEuclid(randomNumArray[0], randomNumArray[1]));
//            String answerString = String.valueOf(answer);
//            if (!Engine.verifyAnswer(gcdByEuclidString, answerString)) {
//                break;
//            }
//        }
//        Engine.doWeHaveAWinner(Engine.getCounterOfCorrectAnswers(), Engine.getNumberOfTries());
//    }

    public static void gcdGame() {
        String[] gameQuestions = new String[Engine.NUMBER_OF_TRIES];
        String[] rightAnswers = new String[Engine.NUMBER_OF_TRIES];
        int[][] randomNumArrays = new int[Engine.NUMBER_OF_TRIES][2];
        for (int i = 0; i < randomNumArrays.length; i++) {
            randomNumArrays[i] = Engine.getRandomNumArray();
            gameQuestions[i] = String.valueOf(randomNumArrays[i][0]) + " "
                    + String.valueOf(randomNumArrays[i][1]);
            rightAnswers[i] = String.valueOf(gcdByEuclid(randomNumArrays[i][0], randomNumArrays[i][1]));
        }
        Engine.runGame(RULES, gameQuestions, rightAnswers);
    }

    public static int gcdByEuclid(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return gcdByEuclid(num2, num1 % num2);
    }
}
