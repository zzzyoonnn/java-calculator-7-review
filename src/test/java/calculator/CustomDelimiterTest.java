package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import calculator.domain.CustomDelimiter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CustomDelimiterTest {
    @ParameterizedTest
    @ValueSource(strings = {"abc\\", "1234n", "~!@#"})
    @DisplayName("커스텀 구분자의 닫는 문자가 존재하지 않는다.")
    public void testNotStartsWithCustomDelimiter(String input) {
        CustomDelimiter customDelimiter = new CustomDelimiter(input);

        assertFalse(customDelimiter.hasEndsWithCustomDelimiter(), input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"///abc\n1234", "//1234\nabc", "////~!@#\n"})
    @DisplayName("커스텀 구분자의 닫는 문자가 존재한다.")
    public void testStartsWithCustomDelimiter(String input) {
        CustomDelimiter customDelimiter = new CustomDelimiter(input);

        assertTrue(customDelimiter.hasEndsWithCustomDelimiter(), input);
    }

    @ParameterizedTest
    @CsvSource(value = {"///abc\\n1234, /abc", "//1234\\nabc, 1234", "//1\\n123, 1", "//.\\n, ."})
    @DisplayName("커스텀 구분자를 추출할 수 있다.")
    public void testSetVariousValue(String userInput, String expectedOutput) {
        CustomDelimiter customDelimiter = new CustomDelimiter(userInput);

        assertThat(customDelimiter.getCustomDelimiter()).isEqualTo(expectedOutput);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//\\n1", "//\\nabc", "//\\n,"})
    @DisplayName("커스텀 구분자가 빈 문자열이라면 에러를 발생시킨다.")
    public void testIsEmpty(String userInput) {
        CustomDelimiter customDelimiter = new CustomDelimiter(userInput);

        assertThrows(IllegalArgumentException.class, () -> customDelimiter.isBlank(customDelimiter.getCustomDelimiter()));
    }
}
