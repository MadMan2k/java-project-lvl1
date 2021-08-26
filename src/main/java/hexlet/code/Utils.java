package hexlet.code;

import java.util.Random;

public class Utils {
    public static final int MIN_OF_RANDOM = 1;
    public static final int MAX_OF_RANDOM = 99;
    private static final Random RANDOM = new Random();

//    public static int getMaxRandom() {
//        return MAX_OF_RANDOM;
//    }

//    private static int getMinRandom() {
//        return  MIN_OF_RANDOM;
//    }

    public static int getRandomNumWithMax(int max) {
        return RANDOM.nextInt(max);
    }

    public static int[] getTwoRandomNumsArrayWithMin() {
        int[] randomNumArray = new int[2];
        randomNumArray[0] = MIN_OF_RANDOM + getRandomNumWithMax(MAX_OF_RANDOM);
        randomNumArray[1] = MIN_OF_RANDOM + getRandomNumWithMax(MAX_OF_RANDOM);
        return randomNumArray;
    }

    public static int[] getRandomNumsArray(int numberOfElements) {
        int[] randomNums = new int[numberOfElements];
        for (int i = 0; i < randomNums.length; i++) {
            randomNums[i] = getRandomNumWithMax(MAX_OF_RANDOM);
        }
        return randomNums;
    }
}
