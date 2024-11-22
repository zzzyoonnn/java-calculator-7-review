package calculator.domain;


import calculator.message.CustomDelimiterErrorMessage;

public class CustomDelimiter {
    private String customString;
    private String customDelimiter;

    public CustomDelimiter(String customString) {
        this.customString = customString;
    }

    public CustomDelimiter(String customDelimiter, String customString) {
        this.customString = customString;
        this.customDelimiter = extractCustomDelimiter(customString);
    }

    private String extractCustomDelimiter(String customString) {
        int startIndex = 2;
        int endIndex = customString.lastIndexOf("\\n");

        return customString.substring(startIndex, endIndex);
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
