package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void setName() {
        Scanner setName = new Scanner(System.in);
        System.out.print("May I have your name? ");
        String name = setName.nextLine();
        System.out.println("Hello, " + name + "!");
    }
}
