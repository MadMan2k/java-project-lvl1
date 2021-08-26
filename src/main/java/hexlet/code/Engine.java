package hexlet.code;

import java.util.Scanner;

public class Engine {

    private static String name;
//    private static final int MIN_OF_RANDOM = 1;
//    private static final int MAX_OF_RANDOM = 99;
    public static final int NUMBER_OF_TRIES = 3;
//    private static final Random RANDOM = new Random();
    public static final String YES_TEXT = "yes";
    public static final String NO_TEXT = "no";

    public static void setPlayerName() {
        name = Cli.getNameFromPlayer();
    }

    private static int counterOfCorrectAnswers = 0;
    static final Scanner SET_ANSWER = new Scanner(System.in);

//    public static int getMaxRandom() {
//        return MAX_OF_RANDOM;
//    }
//
//    private static int getMinRandom() {
//        return  MIN_OF_RANDOM;
//    }

//    public static int getRandomNumWithMax(int max) {
//        return RANDOM.nextInt(max);
//    }

//    public static int[] getTwoRandomNumsArrayWithMin() {
//        int[] randomNumArray = new int[2];
//        randomNumArray[0] = getMinRandom() + getRandomNumWithMax(getMaxRandom());
//        randomNumArray[1] = getMinRandom() + getRandomNumWithMax(getMaxRandom());
//        return randomNumArray;
//    }
//
//    public static int[] getRandomNumsArray(int numberOfElements) {
//        int[] randomNums = new int[numberOfElements];
//        for (int i = 0; i < randomNums.length; i++) {
//            randomNums[i] = getRandomNumWithMax(getMaxRandom());
//        }
//        return randomNums;
//    }

    private static void countCorrectAnswer() {
        counterOfCorrectAnswers++;
    }

    private static int getCounterOfCorrectAnswers() {
        return counterOfCorrectAnswers;
    }

    private static boolean verifyAnswer(String result, String answer) {
        if (answer.equals(result)) {
            printAnswerIsCorrect();
            countCorrectAnswer();
            return true;
        } else {
            printAnswerIsWrong(result, answer);
            printLetsTryAgain();
            return false;
        }
    }

    private static void printQuestion() {
        System.out.print("Question: ");
    }

    private static String stringYourAnswer() {
        System.out.print("Your answer : ");
        return SET_ANSWER.nextLine();
    }

    private static void printAnswerIsCorrect() {
        System.out.println("Correct!");
    }

    private static void printAnswerIsWrong(String result, String answer) {
        System.out.println(String.format("'%s' is wrong answer ;(. Correct answer was '%s'", answer, result));
    }

    private static void printLetsTryAgain() {
        System.out.println("Let's try again, " + name + "!");
    }

    private static void printCongartulations() {
        System.out.println("Congratulations, " + name + "!");
    }

    public static void printError() {
        System.out.println("Error -1");
    }

    private static void checkWinnerAndPrintCongrats(int correctAnswer) {
        if (correctAnswer == NUMBER_OF_TRIES) {
            printCongartulations();
        }
    }

    private static void printRules(String rules) {
        System.out.println(rules);
    }

    private static void printGameQuestion(String gameQuestion) {
        System.out.println(gameQuestion);
    }

    public static void runGame(String rules, String[] gameQuestions, String[] rightAnswers) {
        printRules(rules);
        for (int i = 0; i < NUMBER_OF_TRIES; i++) {
            printQuestion();
            printGameQuestion(gameQuestions[i]);
            String playerAnswer = stringYourAnswer();
            if (!verifyAnswer(rightAnswers[i], playerAnswer)) {
                break;
            }
        }
        checkWinnerAndPrintCongrats(getCounterOfCorrectAnswers());
    }
}
