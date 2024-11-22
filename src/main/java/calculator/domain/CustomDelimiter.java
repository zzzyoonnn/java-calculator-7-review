package calculator.domain;

public class CustomDelimiter {
    private String customString;

    public CustomDelimiter(String customString) {
        this.customString = customString;
    }

    private boolean endsWithCustomDelimiter() {
        return customString.contains("\\n");
    }

    public boolean hasEndsWithCustomDelimiter() {
        return endsWithCustomDelimiter();
    }
}
