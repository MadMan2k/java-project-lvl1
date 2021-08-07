package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    private static final String RULES = "What is the result of the expression?";
    private static final int DECREASE_DIFFICULTY_CALC = 5;
    public static void calcGame() {
        final int numberOfOperators = 3;

        int resultInt = 0;
        System.out.println(RULES);
        for (int i = 0; i < Engine.getNumberOfTries(); i++) {
            int[] randomNumArray = Engine.showRandomNum();
            int showRandomOperator = Engine.getRandomNum().nextInt(numberOfOperators);
            switch (showRandomOperator) {   // 0 ==> sum ; 1 ==> subtraction ; 2 ==>  product ; default ==> error
                case 0:
                    resultInt = sum(randomNumArray[0], randomNumArray[1]);
                    Engine.printQuestion();
                    System.out.println(randomNumArray[0] + " + " + randomNumArray[1]);
                    break;
                case 1:
                    resultInt = subtraction(randomNumArray[0], randomNumArray[1]);
                    Engine.printQuestion();
                    System.out.println(randomNumArray[0] + " - " + randomNumArray[1]);
                    break;
                case 2: // The difficulty decreased to one-fifth of its original level for easier game
                    resultInt = productDifficultyDecreased(randomNumArray[0], randomNumArray[1]);
                    Engine.printQuestion();
                    System.out.println((randomNumArray[0] / DECREASE_DIFFICULTY_CALC) + " * "
                            + (randomNumArray[1] / DECREASE_DIFFICULTY_CALC));
                    break;
                default :
                    Engine.printError();
            }
            int answer = Engine.intYourAnswer();
            String answerString = String.valueOf(answer);
            String resultString = String.valueOf(resultInt);
            if (!Engine.verifyAnswer(resultString, answerString)) {
                break;
            }
        }
        Engine.doWeHaveAWinner(Engine.getCounterOfCorrectAnswers(), Engine.getNumberOfTries());
    }

    public static int sum(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public static int subtraction(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    public static int productDifficultyDecreased(int firstNumber, int secondNumber) {
        return (firstNumber / DECREASE_DIFFICULTY_CALC) * (secondNumber / DECREASE_DIFFICULTY_CALC);
    }
}
