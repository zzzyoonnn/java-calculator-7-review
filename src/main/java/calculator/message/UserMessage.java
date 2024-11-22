package calculator.message;

public enum UserMessage {
    REQUEST_USER_INPUT("덧셈할 문자열을 입력해 주세요."),
    DISPLAY_RESULT("결과 : ");

    private final String message;

    UserMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
