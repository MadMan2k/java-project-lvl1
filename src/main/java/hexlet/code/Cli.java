package hexlet.code;

public class Cli {
    public static void printMayIHaveYourName() {
        System.out.print("May I have your name? ");
    }

    public static void printHelloPlayer() {
        System.out.println("Hello, " + Engine.getName() + "!");
    }
}
