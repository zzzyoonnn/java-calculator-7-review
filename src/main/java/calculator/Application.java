package calculator;

import calculator.controller.CalculatorController;
import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        // TODO: 프로그램 구현
        CalculatorController calculatorController = new CalculatorController();
        calculatorController.run();
    }
}
