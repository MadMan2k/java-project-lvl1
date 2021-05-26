package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    public static void calcGame() {
        final int numberOfOperators = 3;
        final int decreaseDifficultyCalc = 5;
        int resultInt = 0;
        Engine.printRules("calc");
        for (int i = 0; i < Engine.getNumberOfTries(); i++) {
            int[] showRandomNum = Engine.showRandomNum();
            int showRandomOperator = Engine.getRandomNum().nextInt(numberOfOperators);
            switch (showRandomOperator) {   // 0 ==> sum ; 1 ==> subtraction ; 2 ==>  product ; default ==> error
                case 0:
                    resultInt = showRandomNum[0] + showRandomNum[1];
                    Engine.printQuestion();
                    System.out.println(showRandomNum[0] + " + " + showRandomNum[1]);
                    break;
                case 1:
                    resultInt = showRandomNum[0] - showRandomNum[1];
                    Engine.printQuestion();
                    System.out.println(showRandomNum[0] + " - " + showRandomNum[1]);
                    break;
                case 2: // The difficulty decreased to one-fifth of its original level for easier game
                    resultInt = (showRandomNum[0] / decreaseDifficultyCalc) * (showRandomNum[1] / decreaseDifficultyCalc);
                    Engine.printQuestion();
                    System.out.println((showRandomNum[0] / decreaseDifficultyCalc) + " * "
                            + (showRandomNum[1] / decreaseDifficultyCalc));
                    break;
                default :
                    Engine.printError();
            }
            int answer = Engine.intYourAnswer();
            if (!Engine.verifyAnswerInt(resultInt, answer)) {
                break;
            }
        }
        Engine.doWeHaveAWinner(Engine.getCounterOfCorrectAnswers(), Engine.getNumberOfTries());
    }
}
