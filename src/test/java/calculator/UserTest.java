package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import calculator.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserTest {
    @ParameterizedTest
    @ValueSource(strings = {"abc", "1234", "~!@#"})
    @DisplayName("사용자의 입력값을 저장한다.")
    public void testGetUserInput(String input) {
        User user = new User(input);

        assertEquals(user.getUserInputValue(), input);
    }
}
