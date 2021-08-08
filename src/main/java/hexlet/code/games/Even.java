package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    private static final String RULES = "Answer 'yes' if number even otherwise answer 'no'.";
//    public static void evenGame() {
//        String resultString = "";
//        System.out.println(RULES);
//        for (int i = 0; i < Engine.getNumberOfTries(); i++) {
//            int randomNum = Engine.getRandomNum().nextInt(Engine.getMaxRandom());
//            Engine.printQuestion();
//            System.out.println(randomNum);
//            switch (randomNum % 2) {
//                case 0:
//                    resultString = "yes";
//                    break;
//                case 1:
//                    resultString = "no";
//                    break;
//                default:
//                    Engine.printError();
//            }
//            String answer = Engine.stringYourAnswer();
//            if (!Engine.verifyAnswer(resultString, answer)) {
//                break;
//            }
//        }
//        Engine.doWeHaveAWinner(Engine.getCounterOfCorrectAnswers(), Engine.getNumberOfTries());
//    }

    public static void evenGame() {
        String[] gameQuestions = new String[Engine.NUMBER_OF_TRIES];
        String[] rightAnswers = new String[Engine.NUMBER_OF_TRIES];
        int[] randomNums = getRandomNums(Engine.NUMBER_OF_TRIES);
        for (int j = 0; j < gameQuestions.length; j++) {
            gameQuestions[j] = String.valueOf(randomNums[j]);
        }
        for (int k = 0; k < rightAnswers.length; k++) {
            switch (randomNums[k] % 2) {
                case 0:
                    rightAnswers[k] = Engine.YES_TEXT;
                    break;
                case 1:
                    rightAnswers[k] = Engine.NO_TEXT;
                    break;
                default:
                    Engine.printError();
            }
        }
        Engine.runGame(RULES, gameQuestions, rightAnswers);
    }

    private static int[] getRandomNums(int numberOfValues) {
        int[] randomNums = new int[numberOfValues];
        for (int i = 0; i < randomNums.length; i++) {
            randomNums[i] = Engine.getRandomNum().nextInt(Engine.getMaxRandom());
        }
        return randomNums;
    }
}
