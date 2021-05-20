package hexlet.code;

import java.util.Scanner;

public class Cli {
    private static String name;
    public static void setName() {
        Scanner setName = new Scanner(System.in);
        System.out.print("May I have your name? ");
        name = setName.nextLine();
        System.out.println("Hello, " + name + "!");
    }

    public static String getSayMyNameSong() {
        return name;
    }
}
