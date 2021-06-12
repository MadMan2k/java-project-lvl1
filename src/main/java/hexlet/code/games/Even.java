package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    /**
     * Even game class.
     */
    public static void evenGame() {
        String resultString = "";
        String rules = "Answer 'yes' if number even otherwise answer 'no'.";
        System.out.println(rules);
        for (int i = 0; i < Engine.getNumberOfTries(); i++) {
            int randomNum = Engine.getRandomNum().nextInt(Engine.getMaxRandom());
            Engine.printQuestion();
            System.out.println(randomNum);
            switch (randomNum % 2) {
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
