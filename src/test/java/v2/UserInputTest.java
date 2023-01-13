package v2;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {
    void assertProcessor(Method targetMethod, String test) {
        try {
            Object invoke = targetMethod.invoke(UserInput.class, test);
            assertDoesNotThrow(() ->invoke);
            System.out.println("[Case - " + test + "] : 통과");
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getCause().getClass());
            System.out.println("[Case - " + test +  "] : IllegalArgumentException 발생");
        }
    }

    @Test
    @DisplayName("유저의 숫자야구 입력값 검증")
    void validateUserNumberInput_test () throws NoSuchMethodException {
        List<String> tests = List.of(
                "123",  //Test passing case
                "1324", //Raise IllegalArgumentException caused by 'Input Length'
                "14",   //Raise IllegalArgumentException caused by 'Input Length'
                "082",  //Raise IllegalArgumentException caused by 'Input Number range(don't permit zero)'
                "d15",  //Raise IllegalArgumentException caused by 'Input Number format'
                "199"   //Raise IllegalArgumentException caused by 'contains duplicated number'
        );

        Method targetMethod = UserInput.class.getDeclaredMethod("validateUserNumberInput", String.class);
        targetMethod.setAccessible(true);

        tests.forEach((testCase) -> assertProcessor(targetMethod, testCase));
    }

    @Test
    @DisplayName("게임 종료/재시작 입력값 검증 테스트")
    void validateUserRestartInput_test () throws NoSuchMethodException {
        List<String> tests = List.of(
          "Y", //Test passing case
          "N", //Test passing case
          "y", //Raise IllegalArgumentException caused by 'Input format'
          "n", //Raise IllegalArgumentException caused by 'Input format'
          "",  //Raise IllegalArgumentException caused by 'Input format'
          "YY" //Raise IllegalArgumentException caused by 'Input format'
        );

        Method targetMethod = UserInput.class.getDeclaredMethod("validateUserRestartInput", String.class);
        targetMethod.setAccessible(true);

        tests.forEach((testCase) -> assertProcessor(targetMethod, testCase));
    }

    @Test
    @DisplayName("유저 숫자입력 커맨드 테스트")
    void userNumberInputTest() {
        String test = "123"; // test pass case

        System.setIn(new ByteArrayInputStream(test.getBytes()));
        String result = UserInput.userNumberInput();

        assertEquals(test, result);
    }

    @Test
    @DisplayName("유저 게임종료/재시작 입력 테스트")
    void userRestartInputTest() {
        String test = "Y";

        System.setIn(new ByteArrayInputStream(test.getBytes()));
        String result = UserInput.userRestartInput();

        assertEquals(test, result);
    }
}