package hexlet.code;

import java.util.Scanner;

public class Cli {
    static String name;
    public static String setName() {
        Scanner setName = new Scanner(System.in);
        System.out.print("May I have your name? ");
        name = setName.nextLine();
        System.out.println("Hello, " + name + "!");
        return name;
    }
}
