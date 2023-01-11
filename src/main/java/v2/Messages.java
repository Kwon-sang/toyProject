package v2;

public enum Messages {

    GAME_START("숫자 야구 게임을 시작합니다."),
    USER_INPUT("숫자를 입력해 주세요 : "),
    GAME_SECCESS("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    GAME_RESTART("게임을 재시작 하시겠습니까? (Y/N)"),

    ERROR_INPUT_FORMAT("[ERROR] 잘못된 형식의 입력 입니다."),
    ERROR_DUPLICATED("[ERROR] 중복된 숫자가 포함되어 있습니다.");

    private String message;

    Messages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
