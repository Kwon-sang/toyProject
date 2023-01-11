package v2;

import java.util.Arrays;
import java.util.List;

public class GameResult {

    private final String computerNumber;
    private final String userNumber;

    private int strikeCounts = 0;
    private int ballCounts = 0;

    public GameResult(String computerNumber, String userNumber) {
        this.computerNumber = computerNumber;
        this.userNumber = userNumber;
        processResult();
    }

    public boolean isSuccessGame() {
        if (strikeCounts == 3) {
            return true;
        }
        return false;
    }

    private void processResult() {
        List<String> computerNumbers = Arrays.asList(computerNumber.split(""));
        List<String> userNumbers = Arrays.asList(userNumber.split(""));

        for (int i = 0; i < computerNumbers.size(); i++) {
            if (computerNumbers.get(i).equals(userNumbers.get(i))) {
                strikeCounts++;
            } else if (computerNumbers.contains(userNumbers.get(i))) {
                ballCounts++;
            }
        }
    }

    public void printResult() {
        String resultString = "";
        if (strikeCounts != 0) resultString += (strikeCounts + "스트라이크 ");
        if (ballCounts != 0) resultString += (ballCounts + "볼");
        if (strikeCounts + ballCounts == 0) resultString += "낫싱";
        System.out.println(resultString);
    }
}
