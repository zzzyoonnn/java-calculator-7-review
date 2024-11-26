package calculator.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class User {
    private String userInput;

    public User() throws IOException {
        getUserInput();
        processUserInput();
    }

    public User(String userInput) {
        this.userInput = userInput;
    }

    private String[] splitUserInput(String userInput) throws IOException {
        String customDelimiter = getCustomDelimiter(userInput);
        String regex = ",|:" + customDelimiter;

        return userInput.split(regex);
    }

    public boolean hasCustomDelimiter() {
        String userInput = getUserInputValue();

        return !getCustomDelimiter(userInput).isEmpty();
    }

    public String getCustomDelimiter(String userInput) {
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
        String[] result = splitUserInput(input);
    }

    private boolean startsWithCustomDelimiter(String userInput) {
        return userInput.startsWith("//");
    }

    private void getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        userInput = br.readLine();
    }

    public String getUserInputValue() {
        return userInput;
    }

    public boolean isCustomDelimiter() {
        String userInput = getUserInputValue();
        return startsWithCustomDelimiter(userInput);
    }
}
