package hexlet.code;

import java.util.Scanner;

public class Cli {
//    static String name;
    public static String setName() {
        Scanner setName = new Scanner(System.in);
        System.out.print("May I have your name? ");
        Engine.setName(setName.nextLine());
//        Engine.name = setName.nextLine();
//        name = setName.nextLine();
        System.out.println("Hello, " + Engine.getName() + "!");
        return Engine.getName();
    }
}
