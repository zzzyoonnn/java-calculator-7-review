package calculator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import calculator.domain.CustomDelimiter;
import calculator.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CustomDelimiterTest {
    @ParameterizedTest
    @ValueSource(strings = {"abc\\", "1234n", "~!@#\\\n"})
    @DisplayName("커스텀 구분자의 닫는 문자가 존재하지 않는다.")
    public void testNotStartsWithCustomDelimiter(String input) {
        CustomDelimiter customDelimiter = new CustomDelimiter(input);

        assertFalse(customDelimiter.hasEndsWithCustomDelimiter(), input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"///abc\n1234", "//1234\nabc", "////~!@#\n"})
    @DisplayName("커스텀 구분자의 닫는 문자가 존재한다.")
    public void testStartsWithCustomDelimiter(String input) {
        User user = new User(input);

        assertTrue(user.isCustomDelimiter(), input);
    }
}
