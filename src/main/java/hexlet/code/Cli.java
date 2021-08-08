package hexlet.code;

import java.util.Scanner;

public class Cli {
//    static String name;
    public static void printMayIHaveYourName() {
        System.out.print("May I have your name? ");
    }

    public static void printHelloPlayer() {
        System.out.println("Hello, " + Engine.getName() + "!");
    }

    public static String getNameFromPlayer() {
        Scanner playerName = new Scanner(System.in);
        return playerName.nextLine();
    }

    public static void setPlayerName() {
        printMayIHaveYourName();
        String playerName = getNameFromPlayer();
        Engine.setName(playerName);
        printHelloPlayer();
//        return Engine.getName();
    }
}
