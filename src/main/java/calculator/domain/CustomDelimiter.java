package calculator.domain;


import calculator.message.CustomDelimiterErrorMessage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiter {
    private String customString;
    private String customDelimiter;
    private static final String REGEX = "[0-9]+";
    private static final Pattern pattern = Pattern.compile(REGEX);
    private Matcher matcher;

    public CustomDelimiter(String customString) {
        this.customString = customString;
    }

    private String extractCustomDelimiter(String customString) {
        int startIndex = 2;
        int endIndex = customString.lastIndexOf("\\n");

        return customString.substring(startIndex, endIndex);
    }

    public void isDefaultDelimiter(String customDelimiter) {
        if (customDelimiter.equals(",") || customDelimiter.equals(":")) {
            throw new IllegalArgumentException(CustomDelimiterErrorMessage.IS_DEFAULT_DELIMITER.getMessage());
        }
    }

    public void isNumeric(String customDelimiter) {
        if (pattern.matcher(customDelimiter).matches()) {
            throw new IllegalArgumentException(CustomDelimiterErrorMessage.IS_NUMBER.getFormattedMessage());
        }
    }

    public void isBlank(String customDelimiter) {
        if (customDelimiter.isBlank()) {
            throw new IllegalArgumentException(CustomDelimiterErrorMessage.IS_BLANK.getFormattedMessage());
        }
    }

    public String getCustomDelimiter() {
        return extractCustomDelimiter(customString);
    }


    private boolean endsWithCustomDelimiter() {
        return customString.contains("\n");
    }

    public boolean hasEndsWithCustomDelimiter() {
        return endsWithCustomDelimiter();
    }
}
