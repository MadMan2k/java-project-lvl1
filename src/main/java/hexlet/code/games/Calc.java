package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    private static final String RULES = "What is the result of the expression?";
    private static final int DECREASE_DIFFICULTY_CALC = 10;
    private static final String[] OPERATORS = {"+", "-", "*"};
    public static void calcGame() {
        String[] gameQuestions = new String[Engine.NUMBER_OF_TRIES];
        String[] rightAnswers = new String[Engine.NUMBER_OF_TRIES];
        for (int k = 0; k < Engine.NUMBER_OF_TRIES; k++) {
            int firstRandomNum = Utils.MIN_OF_RANDOM + Utils.getRandomNum(Utils.MAX_OF_RANDOM);
            int secondRandomNum = Utils.MIN_OF_RANDOM + Utils.getRandomNum(Utils.MAX_OF_RANDOM);
            String randomOperator = OPERATORS[Utils.getRandomNum(OPERATORS.length)];
            if (randomOperator.equals("*")) { // Difficulty is decreased to one-tenth for easier game
                firstRandomNum = firstRandomNum / DECREASE_DIFFICULTY_CALC;
                secondRandomNum = secondRandomNum / DECREASE_DIFFICULTY_CALC;
            }
            gameQuestions[k] = String.format("%s %s %s", firstRandomNum, randomOperator, secondRandomNum);
            rightAnswers[k] = getRightAnswer(firstRandomNum, secondRandomNum, randomOperator);
        }
        Engine.runGame(RULES, gameQuestions, rightAnswers);
    }

    private static String getRightAnswer(int firstRandomNum, int secondRandomNum, String randomOperator) {
        int resultInt;
        switch (randomOperator) {
            case "+":
                resultInt = firstRandomNum + secondRandomNum;
                break;
            case "-":
                resultInt = firstRandomNum - secondRandomNum;
                break;
            case "*":
                resultInt = firstRandomNum * secondRandomNum;
                break;
            default :
                return "Error -1";
        }
        return String.valueOf(resultInt);
    }
}
