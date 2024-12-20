package calculator.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class User {
    private String userInput;

    public User() throws IOException {
        getUserInput();
//        String[] result = processUserInput();
//        System.out.println(Arrays.toString(result));
    }

    public User(String userInput) {
        this.userInput = userInput;
        //String[] result = processUserInput();
        //System.out.println(Arrays.toString(result));
    }

    private String[] splitUserInput(String userInput, String userInputDelimiter) {
        String regex = ",|:";

        if (!userInputDelimiter.isEmpty()) regex += "|" + userInputDelimiter;

//        if (isCustomDelimiterFound) {
//            regex += "|" + userInputDelimiter;
//        }

        return userInput.split(regex);
    }

//    public void words(String[] arr) {
//
//    }

//    public String hasCustomDelimiter(String userInput, String userCustomDelimiter) {
//        if (!userCustomDelimiter.isEmpty()) {
//            int endIndex = userInput.lastIndexOf("\\n");
//            userInput = userInput.substring(endIndex + 2);
//            System.out.println(userInput);
//        }
//        return userInput;
//    }

//    private String getCustomDelimiter(String userInput) {
//        if (findCustomDelimiter(userInput)) {
//            CustomDelimiter customDelimiter = new CustomDelimiter(userInput);
//            return customDelimiter.getCustomDelimiter();
//        }
//        return null;
//    }
//
//
//    private boolean findCustomDelimiter(String userInput) {
//        int endIndex = userInput.lastIndexOf("\\n");
//
//        return endIndex != -1;
//    }

    public String[] processUserInput() {
        String userInput = getUserInputValue();

        CustomDelimiter customDelimiter = new CustomDelimiter();
        String userCustomDelimiter = "";
        if (startsWithCustomDelimiter(userInput)) {
            customDelimiter.setCustomString(userInput);
            userCustomDelimiter = customDelimiter.getValidCustomDelimiter();
        }

        return splitUserInput(userInput, userCustomDelimiter);
    }

    private boolean startsWithCustomDelimiter(String userInput) {
        return userInput.startsWith("//");
    }

    private void getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        userInput = br.readLine();
        String[] splitString = processUserInput();

        // isEmptyString?
        for (String str : splitString) {
            System.out.println(str);
            if (str.isEmpty()) {
                str = "0";
            }
        }
    }

    public String getUserInputValue() {
        return userInput;
    }

    public boolean isCustomDelimiter() {
        String userInput = getUserInputValue();
        return startsWithCustomDelimiter(userInput);
    }
}
