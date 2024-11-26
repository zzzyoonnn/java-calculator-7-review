package calculator.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class User {
    private String userInput;

    public User() throws IOException {
        getUserInput();
        processUserInput();
    }

    public User(String userInput) {
        this.userInput = userInput;
    }

    public boolean hasCustomDelimiter() throws IOException {
        String userInput = getUserInputValue();

        return !getCustomDelimiter(userInput).isEmpty();
    }

    public String getCustomDelimiter(String userInput) throws IOException {
        if (startsWithCustomDelimiter(userInput)) {
            return fingCustomDelimiter(userInput);
        }
        return "";
    }


    private String fingCustomDelimiter(String userInput) {
        CustomDelimiter customDelimiter = new CustomDelimiter(userInput);
        return customDelimiter.getValidCustomDelimiter();
    }

    private void processUserInput() throws IOException {
        String input = getUserInputValue();

        getCustomDelimiter(input);
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
