package v2;

import java.util.LinkedHashSet;
import java.util.Set;

public class Random {
    /**
     * create random three-digit number in range 1~9 with non-duplicated each digit
     * @return String
     */
    public static String createRandomThreeDigitNum() {
        Set<String> duplicateChecker = new LinkedHashSet<>();
        while (duplicateChecker.size() < 3) {
            String randomStringNumber = String.valueOf((int)(Math.random() * 10));
            if (!randomStringNumber.equals("0") && !duplicateChecker.contains(randomStringNumber)) {
                duplicateChecker.add(randomStringNumber);
            }
        }
        return String.join("", duplicateChecker);
    }
}
