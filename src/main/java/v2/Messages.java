package v2;

public enum Messages {

    USER_INPUT("숫자를 입력해 주세요 : "),
    GAME_SUCCESS("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 재시작 하시겠습니까? (Y/N)" ),

    ERROR_NUMBER_FORMAT("[ERROR] 입력은 1~9 까지의 숫자 3자리를 입력해야 합니다."),
    ERROR_YN_FORMAT("[ERROR] Y또는 N만 입력 가능합니다."),
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
