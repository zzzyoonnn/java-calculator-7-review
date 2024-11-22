package calculator.controller;

import calculator.domain.User;
import calculator.view.UserView;
import java.io.IOException;

public class CalculatorController {

    public void run() throws IOException {
        // 계산기 실행
        UserView.displayRequestUserInput();
        // 유저 인풋받기
        User user = new User();
    }


}
