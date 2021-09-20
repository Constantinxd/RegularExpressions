import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegularExpressionsTest {

    @Test
    void isIPv4() {
        assertAll(
                () -> assertTrue(RegularExpressions.isIPv4("0.0.0.0"))
        );

        assertAll(
                () -> assertFalse(RegularExpressions.isIPv4("256.256.256.256"))
        );
    }

    @Test
    void isGUID() {
        assertAll(
                () -> assertTrue(RegularExpressions.isGUID("ac556b4a-cfd4-456c-ac35-a74e9f17e3e6"))
        );

        assertAll(
                () -> assertFalse(RegularExpressions.isGUID("Gc556b4a-cfd4-456c-ac35-a74e9f17e3e6"))
        );
    }

    @Test
    void isURL() {
        assertAll(
                () -> assertTrue(RegularExpressions.isURL("yandex.ru"))
        );

        assertAll(
                () -> assertFalse(RegularExpressions.isURL("-yandex.ru"))
        );
    }

    @Test
    void isValidPassword() {
        assertAll(
                () -> assertTrue(RegularExpressions.isValidPassword("C00l_Password"))
        );

        assertAll(
                () -> assertFalse(RegularExpressions.isValidPassword("Pass1"))
        );
    }
}