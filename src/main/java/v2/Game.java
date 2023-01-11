package v2;

public class Game {

    private String computerNumber;

    public void run() {
        boolean keepGoing = true;
        while (keepGoing) {
            keepGoing = singleGame();
        }
    }

    private boolean singleGame() {
        computerNumber = Utilities.createRandomThreeDigitNum();
        //편의를 위한 컴퓨터 숫자 출력
        System.out.println("(For Example, a Computer number is " + computerNumber + ")");

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
