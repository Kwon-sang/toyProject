package v1;

import java.io.IOException;
import java.util.*;

public class Application_v1 {

    private static String ANSWER;

    public static void main(String[] args) throws IOException {
        // Message output : Game start message
        System.out.println("숫자 야구 게임을 시작합니다.");

        // Loop for repeat game
        boolean gameRunState = true;
        while (gameRunState == true) {
            ANSWER = createRandomThreeDigitNum();
            System.out.println("(For Example, a Computer number is " + ANSWER + ")");

            // Loop for game process step
            boolean threeStrike = false;
            while (threeStrike == false) {
                System.out.print("숫자를 입력해 주세요 : ");
                String userInputNumber = readLine();

                List<Integer> result = result(userInputNumber);
                Integer strikeCount = result.get(0);
                Integer ballCount = result.get(1);

                printResult(strikeCount, ballCount);

                if (strikeCount == 3) {
                    threeStrike = true;
                }
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 재시작 하시겠습니까? (Y/N)");
            String readLine = readLine();
            if (readLine.equals("N")) gameRunState = false;
        }
    }

    private static String readLine() throws IOException {
        StringBuilder buffer = new StringBuilder();

        boolean endOfRead = false;
        while (!endOfRead) {
            int read = System.in.read();
            if (read == '\n') endOfRead = true;
            else buffer.append((char) read);
        }
        return buffer.toString();
    }

    private static String createRandomThreeDigitNum() {
        Set<String> duplicateChecker = new LinkedHashSet<>();
        while (duplicateChecker.size() < 3) {
            String randomStringNumber = String.valueOf((int)(Math.random() * 10));
            if (!randomStringNumber.equals("0") && !duplicateChecker.contains(randomStringNumber)) {
                duplicateChecker.add(randomStringNumber);
            }
        }
        return String.join("", duplicateChecker);
    }

    private static List<Integer> result(String userInputNumber) {
        List<String> answerNumbers = Arrays.asList(ANSWER.split(""));
        List<String> userInputNumbers = Arrays.asList(userInputNumber.split(""));

        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < answerNumbers.size(); i++) {
            if (answerNumbers.get(i).equals(userInputNumbers.get(i))) {
                strikeCount++;
            } else if (answerNumbers.contains(userInputNumbers.get(i))) {
                ballCount++;
            }
        }

        return List.of(strikeCount, ballCount);
    }

    private static void printResult(int strikeCount, int ballCount) {
        String resultString = "";
        if (strikeCount != 0) resultString += (strikeCount + "스트라이크 ");
        if (ballCount != 0) resultString += (ballCount + "볼");
        if (strikeCount + ballCount == 0) resultString += "낫싱";
        System.out.println(resultString);
    }
}
