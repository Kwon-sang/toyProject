package v2;

public class Game {

    private String computerNumber;

    public void run() {

        boolean keepGoing = true;
        while (keepGoing) {
            keepGoing = singleGame();
        }
    }

    /**
     * Run One-time single game.
     * if you want restart game, enter "Y" to console, if not enter "N".
     * @return true(restart)/false(end game).
     */
    private boolean singleGame() {
        computerNumber = Random.createRandomThreeDigitNum();

        boolean successGame = false;
        while (!successGame) {
            successGame = unitGame();
        }

        return UserInput.userRestartInput().equals("Y");
    }

    /**
     * Atomic unit game.
     * in this method, about the user input number compare to computer number, then printing result with count Strike and Ball.
     *
     * @return if Strike count is 3(game success), return true or not false.
     */
    private boolean unitGame() {
        StrikeAndBallCounter strikeAndBallCounter = new StrikeAndBallCounter(computerNumber, UserInput.userNumberInput());
        strikeAndBallCounter.printResult();
        return strikeAndBallCounter.isSuccessGame();
    }
}
