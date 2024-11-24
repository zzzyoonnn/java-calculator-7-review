package calculator.message;

public enum CustomDelimiterErrorMessage implements ErrorMessage {
    IS_BLANK("커스텀 문자열로 null은 불가합니다."),
    IS_NUMBER("커스텀 문자열로 숫자는 불가합니다."),
    IS_DEFAULT_DELIMITER("커스텀 문자열은 기본 문자열과 동일할 수 없습니다.");

    private final String message;

    CustomDelimiterErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
