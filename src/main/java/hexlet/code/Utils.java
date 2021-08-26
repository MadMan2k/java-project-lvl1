package hexlet.code;

import java.util.Random;

public class Utils {
    public static final int MIN_OF_RANDOM = 1;
    public static final int MAX_OF_RANDOM = 99;
    private static final Random RANDOM = new Random();

    public static int getRandomNum(int max) {
        return RANDOM.nextInt(max);
    }
}
