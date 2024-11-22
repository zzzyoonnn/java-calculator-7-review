package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiter {
    private String customString;
    private final String startDelimiter = "//";
    private final String endDelimiter = "\\\n";

    public CustomDelimiter(String customString) {
        this.customString = customString;
    }

    private String extractCustomDelimiter(String customString) {
        String regex = startDelimiter + "(.*?)" + endDelimiter;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(customString);

        return matcher.group(1);
    }

    public String getCustomDelimiter(String customString) {
        return extractCustomDelimiter(customString);
    }


    private boolean endsWithCustomDelimiter() {
        return customString.contains("\\n");
    }

    public boolean hasEndsWithCustomDelimiter() {
        return endsWithCustomDelimiter();
    }
}
