package v2;

import java.util.Arrays;
import java.util.List;

/**
 * Based on Computer number and User Number, update fields of the number of 'Strike' and 'Ball' counts.
 */
public class StrikeAndBallCounter {

    private final String computerNumber;
    private final String userNumber;

    private int strikeCounts = 0;
    private int ballCounts = 0;

    public StrikeAndBallCounter(final String computerNumber, final String userNumber) {
        this.computerNumber = computerNumber;
        this.userNumber = userNumber;
        initCounts(computerNumber, userNumber);
    }

    public boolean isSuccessGame() {
        return strikeCounts == 3;
    }

    private void initCounts(final String computerNumber, final String userNumber) {
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
        StringBuilder resultString = new StringBuilder();
        if (strikeCounts != 0) resultString.append(strikeCounts).append("스트라이크 ");
        if (ballCounts != 0) resultString.append(ballCounts).append("볼");
        if (strikeCounts + ballCounts == 0) resultString.append("낫싱");
        System.out.println(resultString.toString());
    }
}
