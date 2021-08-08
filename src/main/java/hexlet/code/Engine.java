package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {

    private static String name;

    public static void setName(String scannerName) {
        name = scannerName;
    }

    public static String getName() {
        return name;
    }

    private static int counterOfCorrectAnswers = 0;
    static final Scanner SET_ANSWER = new Scanner(System.in);

    public static int getMaxRandom() {
        final int maxRandom = 99;
        return maxRandom;
    }

    public static int getMinRandom() {
        final int minRandom = 1;
        return minRandom;
    }

    public static Random getRandomNum() {
        Random randomNum = new Random();
        return randomNum;
    }

    public static int[] showRandomNumArray() {
        int[] showRandomNum = new int[2];
        showRandomNum[0] = Engine.getMinRandom() + Engine.getRandomNum().nextInt(Engine.getMaxRandom());
        showRandomNum[1] = Engine.getMinRandom() + Engine.getRandomNum().nextInt(Engine.getMaxRandom());
        return showRandomNum;
    }

    public static int getNumberOfTries() {
        final int numberOfTries = 3;
        return numberOfTries;
    }


    public static void countCorrectAnswer() {
        counterOfCorrectAnswers++;
    }

    public static int getCounterOfCorrectAnswers() {
        return counterOfCorrectAnswers;
    }

    public static boolean verifyAnswer(String result, String answer) {
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

    public static void printQuestion() {
        System.out.print("Question: ");
    }

    public static String stringYourAnswer() {
        System.out.print("Your answer : ");
        return SET_ANSWER.nextLine();
    }

    public static int intYourAnswer() {
        System.out.print("Your answer : ");
        return Integer.parseInt(SET_ANSWER.nextLine());
    }

    public static void printAnswerIsCorrect() {
        System.out.println("Correct!");
    }

    public static void printAnswerIsWrong(String result, String answer) {
        System.out.println(String.format("'%s' is wrong answer ;(. Correct answer was '%s'", answer, result));
    }

    public static void printLetsTryAgain() {
        System.out.println("Let's try again, " + Engine.getName() + "!");
    }

    public static void printCongartulations() {
        System.out.println("Congratulations, " + Engine.getName() + "!");
    }

    public static void printError() {
        System.out.println("Error -1");
    }

    public static void doWeHaveAWinner(int correctAnswer, int numberOfTries) {
        if (correctAnswer == numberOfTries) {
            printCongartulations();
        }
    }

    public static void printRules(String rules) {
        System.out.println(rules);
    }

    public static void printGameQuestion(String gameQuestion) {
        System.out.println(gameQuestion);
    }

    public static void runGame(String rules, String[] gameQuestions, String[] rightAnswers) {
        printRules(rules);
        for (int i = 0; i < Engine.getNumberOfTries(); i++) {
            Engine.printQuestion();
            printGameQuestion(gameQuestions[i]);
            String playerAnswer = Engine.stringYourAnswer();
            if (!Engine.verifyAnswer(rightAnswers[i], playerAnswer)) {
                break;
            }
        }
        Engine.doWeHaveAWinner(Engine.getCounterOfCorrectAnswers(), Engine.getNumberOfTries());
    }
}
