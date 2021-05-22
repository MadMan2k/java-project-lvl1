package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {

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

    public static int[] showRandomNum() {
        int[] showRandomNum = new int[2];
        showRandomNum[0] = Engine.getMinRandom() + Engine.getRandomNum().nextInt(Engine.getMaxRandom());
        showRandomNum[1] = Engine.getMinRandom() + Engine.getRandomNum().nextInt(Engine.getMaxRandom());
        return showRandomNum;
    }

    public static int getNumberOfTries() {
        final int numberOfTries = 3;
        return numberOfTries;
    }

    public static int getNumberOfOperators() {
        final int numberOfOperators = 3;
        return numberOfOperators;
    }

    public static void printQuestion() {
        System.out.print("Question : ");
    }

    public static String stringYourAnswer() {
        Scanner setAnswer = new Scanner(System.in);
        System.out.print("Your answer : ");
        String answer = setAnswer.nextLine();
        return answer;
    }

    public static int intYourAnswer() {
        Scanner setAnswer = new Scanner(System.in);
        System.out.print("Your answer : ");
        int answer = Integer.parseInt(setAnswer.nextLine());
        return answer;
    }

    public static void printCorrect() {
        System.out.println("Correct!");
    }

    public static void printLetsTryAgain() {
        System.out.println("Let's try again, " + Cli.getSayMyNameSong() + "!");
    }

    public static void printCongartulations() {
        System.out.println("Congratulations, " + Cli.getSayMyNameSong() + "!");
    }

    public static void printError() {
        System.out.println("Error -1");
    }
}
