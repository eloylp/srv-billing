package billing.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @ParameterizedTest(name = "{index} Must accept name: {0}")
    @ValueSource(strings = {"PLC", "plc", "christmas discount"})
    void testAcceptedValues(String value) throws InvalidNameException {
        new Name(value);

    }

    @ParameterizedTest(name = "{index} Must not accept short names like: {0}")
    @ValueSource(strings = {"n", ""})
    void testNotAcceptedValues(String value) {
        assertThrows(InvalidNameException.class, () -> new Name(value));
    }

    @Test
    void testNoNullAccepted() {
        assertThrows(InvalidNameException.class, () -> new Name(null));

    }

}