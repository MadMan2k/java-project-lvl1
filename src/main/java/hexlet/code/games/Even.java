package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    private static final String RULES = "Answer 'yes' if number even otherwise answer 'no'.";
    public static void evenGame() {
        String resultString = "";
        System.out.println(RULES);
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
            if (!Engine.verifyAnswer(resultString, answer)) {
                break;
            }
        }
        Engine.doWeHaveAWinner(Engine.getCounterOfCorrectAnswers(), Engine.getNumberOfTries());
    }
}
