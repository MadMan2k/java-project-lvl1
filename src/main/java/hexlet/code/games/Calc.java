package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Random;

public class Calc {
    private static final String RULES = "What is the result of the expression?";
    private static final int DECREASE_DIFFICULTY_CALC = 10;
    private static final int[] OPERATORS = {0, 1, 2}; // 0 ==> sum; 1 ==> subtraction; 2 ==> product;
    public static void calcGame() {
        String[] gameQuestions = new String[Engine.NUMBER_OF_TRIES];
        String[] rightAnswers = new String[Engine.NUMBER_OF_TRIES];
        for (int k = 0; k < Engine.NUMBER_OF_TRIES; k++) {
            int firstRandomNum = Utils.MIN_OF_RANDOM + Utils.getRandomNum(Utils.MAX_OF_RANDOM);
            int secondRandomNum = Utils.MIN_OF_RANDOM + Utils.getRandomNum(Utils.MAX_OF_RANDOM);
            int randomOperator = OPERATORS[new Random().nextInt(OPERATORS.length)];
            gameQuestions[k] = getGameQuestion(firstRandomNum, secondRandomNum, randomOperator);
            rightAnswers[k] = getRightAnswer(randomOperator, firstRandomNum, secondRandomNum);
        }
        Engine.runGame(RULES, gameQuestions, rightAnswers);
    }

    private static String getRightAnswer(int randomOperator, int firstRandomNum, int secondRandomNum) {
        int resultInt = 0;
        switch (randomOperator) { // 0 ==> sum; 1 ==> subtraction; 2 ==> product; default ==> error
            case 0:
                resultInt = firstRandomNum + secondRandomNum;
                break;
            case 1:
                resultInt = firstRandomNum - secondRandomNum;
                break;
            case 2: // The difficulty decreased to one-tenth of its original level for easier game
                resultInt = (firstRandomNum / DECREASE_DIFFICULTY_CALC) * (secondRandomNum / DECREASE_DIFFICULTY_CALC);
                break;
            default :
                return "Error -1";
        }
        return String.valueOf(resultInt);
    }

    private static String getGameQuestion(int firstNum, int secondNum, int operator) {
        String gameQuestion;
        switch (operator) { // 0 ==> sum; 1 ==> subtraction; 2 ==> product;
            case 0:
                gameQuestion = String.format("%s + %s", firstNum, secondNum);
                break;
            case 1:
                gameQuestion = String.format("%s - %s", firstNum, secondNum);
                break;
            case 2:
                gameQuestion = String.format("%s * %s", firstNum / DECREASE_DIFFICULTY_CALC,
                        secondNum / DECREASE_DIFFICULTY_CALC);
                break;
            default:
                gameQuestion = "Error -1";
        }
        return gameQuestion;
    }
}
