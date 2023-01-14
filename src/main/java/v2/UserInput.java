package v2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UserInput {

    public static String userNumberInput() {
        System.out.print(Messages.USER_INPUT);
        String userNumberInput = new Scanner(System.in).next();
        validateUserNumberInput(userNumberInput);
        return userNumberInput;
    }

    public static String userRestartInput() {
        System.out.println(Messages.GAME_SUCCESS);
        String userRestartInput = new Scanner(System.in).next();
        validateUserRestartInput(userRestartInput);
        return userRestartInput;
    }

    private static void validateUserNumberInput(String userNumberInput) {
        validateUserInputFormat(userNumberInput);
        validateUserInputDuplicate(userNumberInput);
    }

    private static void validateUserInputFormat(String userNumberInput) {
        String format = "[1-9][1-9][1-9]";
        if (!userNumberInput.matches(format)) {
            throw new IllegalArgumentException(Messages.ERROR_NUMBER_FORMAT.toString());
        }
    }

    private static void validateUserInputDuplicate(String userNumberInput) {
        Set<String> duplicateInspector = new HashSet<>();
        for (String number : userNumberInput.split("")) {
            if (!duplicateInspector.contains(number)) {
                duplicateInspector.add(number);
            } else {
                throw new IllegalArgumentException(Messages.ERROR_DUPLICATED.toString());
            }
        }
    }

    private static void validateUserRestartInput(String userRestartInput) {
        String format = "[YN]";
        if (!userRestartInput.matches(format)) {
            throw new IllegalArgumentException(Messages.ERROR_YN_FORMAT.toString());
        }
    }
}
