package calculator.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class User {
    private String userInput;

    public User() throws IOException {
        startUserInput();
    }

    public User(String userInput) {
        this.userInput = userInput;
    }

    public boolean hasCustomDelimiter() throws IOException {
        String customDelimiter = startUserInput();

        return !customDelimiter.isEmpty();
    }

    private String startUserInput() throws IOException {
        String userInput = getUserInput();

        String customDelimiterValue = "";
        if (startsWithCustomDelimiter(userInput)) {
            CustomDelimiter customDelimiter = new CustomDelimiter(userInput);
            customDelimiterValue = customDelimiter.getValidCustomDelimiter();
        }

        return customDelimiterValue;
    }

    private boolean startsWithCustomDelimiter(String userInput) {
        return userInput.startsWith("//");
    }

    private String getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        return br.readLine();
    }

    public String getUserInputValue() {
        return userInput;
    }

    public boolean isCustomDelimiter() {
        String userInput = getUserInputValue();
        return startsWithCustomDelimiter(userInput);
    }
}
