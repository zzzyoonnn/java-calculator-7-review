package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
    @CsvSource(value = {"///abc\\n1234, /abc", "//1234\\nabc, 1234", "//\\n123, ", "//.\\n, ."})
    @DisplayName("입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능지를 확인하는 학습 테스트")
    public void testSetVariousValue(String userInput, String expectedOutput) {
        CustomDelimiter customDelimiter = new CustomDelimiter(userInput);

        assertThat(customDelimiter.getCustomDelimiter()).isEqualTo(expectedOutput);
    }
}
