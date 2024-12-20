package calculator.message;

public interface ErrorMessage {
    String getMessage();

    default String getFormattedMessage() {
        return "[ERROR] " + getMessage();
    }
}
