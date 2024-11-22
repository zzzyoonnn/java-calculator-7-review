package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1234", "~!@#"})
    @DisplayName("사용자의 입력이 커스텀 구분자의 경우로 시작하지 않는다.")
    public void testNotStartsWithCustomDelimiter(String input) {
        User user = new User(input);

        assertFalse(user.isCustomDelimiter(), input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"///abc", "//1234", "////~!@#"})
    @DisplayName("사용자의 입력이 커스텀 구분자의 경우로 시작한다.")
    public void testStartsWithCustomDelimiter(String input) {
        User user = new User(input);

        assertTrue(user.isCustomDelimiter(), input);
    }
}
