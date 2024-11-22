package calculator.view;

import static calculator.message.UserMessage.REQUEST_USER_INPUT;

public class UserView {
    public static void displayRequestUserInput() {
        System.out.println(REQUEST_USER_INPUT.getMessage());
    }
}
