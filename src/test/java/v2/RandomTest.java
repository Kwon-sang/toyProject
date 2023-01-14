package v2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RandomTest {

    String randomThreeDigitNum;

    @Test
    @DisplayName("컴퓨터 번호생성 검증 - 1000회")
    void createRandomThreeDigitNum_Test() {
        for (int i = 0; i < 100; i++) {
            randomThreeDigitNum = Random.createRandomThreeDigitNum();
            assertDoesNotThrow(() -> validateComputerNumber(randomThreeDigitNum));
        }
    }

    void validateComputerNumber(String randomThreeDigitNum) {
        Set<String> set = new HashSet<>();
        Arrays.stream(randomThreeDigitNum.split("")).forEach(set::add);
        //for duplicate
        if (set.size() != 3) throw new IllegalArgumentException();
        //for contains zero or ten
        if (set.contains("0") || set.contains("10")) throw new IllegalArgumentException();
    }
}