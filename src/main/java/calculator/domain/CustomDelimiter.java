package calculator.domain;


public class CustomDelimiter {
    private String customString;

    public CustomDelimiter(String customString) {
        this.customString = customString;
    }

    private String extractCustomDelimiter(String customString) {
        int startIndex = 2;
        int endIndex = customString.lastIndexOf("\\n");

        return customString.substring(startIndex, endIndex);
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
