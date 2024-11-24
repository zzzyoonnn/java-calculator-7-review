package calculator.domain;


import calculator.message.CustomDelimiterErrorMessage;
import java.util.regex.Pattern;

public class CustomDelimiter {
    private final String customString;
    private static final String REGEX = "[0-9]+";
    private static final Pattern pattern = Pattern.compile(REGEX);

    public CustomDelimiter(String customString) {
        this.customString = customString;
    }

    public String getValidCustomDelimiter() {
        String customDelimiter = extractCustomDelimiter(customString);
        isValidCustomDelimiter(customDelimiter);

        return customDelimiter;
    }

    public String isValidCustomDelimiter(String customDelimiter) {
        isBlank(customDelimiter);
        isNumeric(customDelimiter);
        isDefaultDelimiter(customDelimiter);

        return customDelimiter;
    }

    private String extractCustomDelimiter(String customString) {
        int startIndex = 2;
        int endIndex = customString.lastIndexOf("\\n");

        return customString.substring(startIndex, endIndex);
    }


    private void isDefaultDelimiter(String customDelimiter) {
        if (customDelimiter.equals(",") || customDelimiter.equals(":")) {
            throw new IllegalArgumentException(CustomDelimiterErrorMessage.IS_DEFAULT_DELIMITER.getMessage());
        }
    }

    private void isNumeric(String customDelimiter) {
        if (pattern.matcher(customDelimiter).matches()) {
            throw new IllegalArgumentException(CustomDelimiterErrorMessage.IS_NUMBER.getFormattedMessage());
        }
    }

    private void isBlank(String customDelimiter) {
        if (customDelimiter.isBlank()) {
            throw new IllegalArgumentException(CustomDelimiterErrorMessage.IS_BLANK.getFormattedMessage());
        }
    }

    public String getCustomDelimiter() {
        return extractCustomDelimiter(customString);
    }


    private boolean endsWithCustomDelimiter() {
        return customString.contains("\\n");
    }

    public boolean hasEndsWithCustomDelimiter() {
        return endsWithCustomDelimiter();
    }
}
