package calculator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import calculator.domain.User;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

//    @ParameterizedTest
//    @CsvSource(strings = {"//abc\\n1234, 1234", "//1a2b3c\\nabc, abc"})
//    @DisplayName("커스텀 구분자를 보유하고 있다.")
//    public void testHasCustomDelimiter(String input, String expected) {
//        User user = new User(input);
//
//        assertEquals(user.hasCustomDelimiter(), expected);
//    }

//    @ParameterizedTest
//    @ValueSource(strings = {"", "1,2", "1,2,3", "1,2:3"})
//    @DisplayName("커스텀 구분자를 보유하고 있지 않다.")
//    public void testHasNotCustomDelimiter(String input) {
//        User user = new User(input);
//
//        assertFalse(user.hasCustomDelimiter());
//    }


    @Test
    @DisplayName("기본 구분자로 문자열을 자를 수 있다.")
    public void testsSplitDefaultDelimiter() {
        User user = new User("1,2,3");
        String[] result = user.processUserInput();
        String[] expectedArray = {"1", "2", "3"};

        assertArrayEquals(expectedArray, result);
    }

    @Test
    @DisplayName("커스텀 구분자로 문자열을 자를 수 있다.")
    public void testCustomDelimiter() {
        User user = new User("//;\\n1;2;3");
        String[] result = user.processUserInput();
        String[] expectedArray = {"1", "2", "3"};

        assertArrayEquals(expectedArray, result);
    }

    @Test
    @DisplayName("기본 구분자와 커스텀 구분자로 문자열을 자를 수 있다.")
    public void testsSplitDefaultAndCustomDelimiter() {
        User user = new User("//abc\\n1234,12:34,5");
        String[] result = user.processUserInput();
        String[] expectedArray = {"1234", "12", "34", "5"};

        assertArrayEquals(expectedArray, result);
    }

    @Test
    @DisplayName("기본 구분자와 커스텀 구분자로 문자열을 자를 수 있다.")
    public void testsSplitDefaultAndCustomDelimiter2() {
        User user = new User("//abc\\nab,c:d,5");
        String[] result = user.processUserInput();
        String[] expectedArray = {"ab", "c", "d", "5"};

        assertArrayEquals(expectedArray, result);
    }
}
