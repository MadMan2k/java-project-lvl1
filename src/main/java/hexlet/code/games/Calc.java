package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    private static final String RULES = "What is the result of the expression?";
    private static final int DECREASE_DIFFICULTY_CALC = 10;
    public static void calcGame() {
        String[] gameQuestions = new String[Engine.NUMBER_OF_TRIES];
        String[] rightAnswers = new String[Engine.NUMBER_OF_TRIES];
        int[] resultInt = new int[Engine.NUMBER_OF_TRIES];
        int[][] randomNumArrays = new int[Engine.NUMBER_OF_TRIES][2];
        for (int i = 0; i < randomNumArrays.length; i++) {
            randomNumArrays[i] = Engine.getRandomNumArray();
        }
        int[] randomOperators = getRandomOperators(); // 0 ==> sum ; 1 ==> subtraction ; 2 ==>  product ;
        for (int k = 0; k < randomNumArrays.length; k++) {
            switch (randomOperators[k]) { // 0 ==> sum ; 1 ==> subtraction ; 2 ==>  product ; default ==> error
                case 0:
                    gameQuestions[k] = gameQuestion(randomNumArrays[k][0], randomNumArrays[k][1], "+");
                    resultInt[k] = sum(randomNumArrays[k][0], randomNumArrays[k][1]);
                    rightAnswers[k] = resultToString(resultInt[k]);
                    break;
                case 1:
                    gameQuestions[k] = gameQuestion(randomNumArrays[k][0], randomNumArrays[k][1], "-");
                    resultInt[k] = subtraction(randomNumArrays[k][0], randomNumArrays[k][1]);
                    rightAnswers[k] = resultToString(resultInt[k]);
                    break;
                case 2: // The difficulty decreased to one-tenth of its original level for easier game
                    gameQuestions[k] = gameQuestion(randomNumArrays[k][0], randomNumArrays[k][1], "*");
                    resultInt[k] = productDifficultyDecreased(randomNumArrays[k][0], randomNumArrays[k][1]);
                    rightAnswers[k] = resultToString(resultInt[k]);
                    break;
                default :
                    Engine.printError();
            }
        }
        Engine.runGame(RULES, gameQuestions, rightAnswers);
    }

    private static String resultToString(int rightAnswer) {
        return String.valueOf(rightAnswer);
    }

    private static String gameQuestion(int firstNum, int secondNum, String operator) {
        String gameQuestion;
        switch (operator) {
            case "+":
                gameQuestion = String.format("%s + %s", firstNum, secondNum);
                break;
            case "-":
                gameQuestion = String.format("%s - %s", firstNum, secondNum);
                break;
            case "*":
                gameQuestion = String.format("%s * %s", firstNum / DECREASE_DIFFICULTY_CALC,
                        secondNum / DECREASE_DIFFICULTY_CALC);
                break;
            default:
                gameQuestion = "Error -1";
        }
        return gameQuestion;
    }

    private static int[] getRandomOperators() {
        final int numberOfOperators = 3;
        int[] randomOperators = new int[Engine.NUMBER_OF_TRIES];
        for (int j = 0; j < randomOperators.length; j++) {
            randomOperators[j] = Engine.getRandomNumWithMax(numberOfOperators);
        }
        return randomOperators;
    }

    private static int sum(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    private static int subtraction(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    private static int productDifficultyDecreased(int firstNumber, int secondNumber) {
        return (firstNumber / DECREASE_DIFFICULTY_CALC) * (secondNumber / DECREASE_DIFFICULTY_CALC);
    }
}
