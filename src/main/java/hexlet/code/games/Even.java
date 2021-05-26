package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    /**
     * Even game class.
     */
    public static void evenGame() {
        String resultString = "";
        Engine.printRules("even");
        for (int i = 0; i < Engine.getNumberOfTries(); i++) {
            int[] showRandomNum = Engine.showRandomNum();
            Engine.printQuestion();
            System.out.println(showRandomNum[0]);
            switch (showRandomNum[0] % 2) {
                case 0:
                    resultString = "yes";
                    break;
                case 1:
                    resultString = "no";
                    break;
                default:
                    Engine.printError();
            }
            String answer = Engine.stringYourAnswer();
            if (!Engine.verifyAnswerString(resultString, answer)) {
                break;
            }
        }
        Engine.doWeHaveAWinner(Engine.getCounterOfCorrectAnswers(), Engine.getNumberOfTries());
    }
}
