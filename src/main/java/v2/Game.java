package v2;

public class Game {

    private String computerNumber;

    public void run() {
        System.out.println(Messages.GAME_START);
        boolean keepGoing = true;
        while (keepGoing) {
            keepGoing = singleGame();
        }
    }

    private boolean singleGame() {
        computerNumber = Utilities.createRandomThreeDigitNum();

        boolean successGame = false;
        while (!successGame) {
            successGame = gameStep();
        }

        return UserInput.userRestartInput().equals("Y");
    }

    private boolean gameStep() {
        GameResult gameResult = new GameResult(computerNumber, UserInput.userNumberInput());
        gameResult.printResult();
        return gameResult.isSuccessGame();
    }
}
