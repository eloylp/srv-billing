package billing.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PositivePercentageTest {

    class ConcretePercentage extends PositivePercentage {
        ConcretePercentage(String name, Value percent) throws BillingException {
            super(name, percent);
        }
    }

    @ParameterizedTest(name = "{index} Percentage must accept this positive values: {0}")
    @ValueSource(doubles = {-0.00, 0.00, 0.01, 1.33, 0.0001, 1.0, 345.67})
    void testAcceptedValues(Double value) throws BillingException {
        new ConcretePercentage("name", new Value(value));

    }

    @ParameterizedTest(name = "{index} Percentage must not accept negative values like: {0}")
    @ValueSource(doubles = {-0.01, -1.0, -345.67})
    void testNotAcceptedValues(Double value) {
        assertThrows(NegativeNumberException.class, () -> new ConcretePercentage("tax", new Value(value)));
    }

    @ParameterizedTest(name = "{index} Percentage must accept this name: {0}")
    @ValueSource(strings = {"", ""})
    void testAcceptedValues(String value) throws BillingException {
        new ConcretePercentage(value, new Value(1));
    }

    @Test
    void testNullDiscarded() {
        assertThrows(NegativeNumberException.class, () -> new ConcretePercentage("tax", null));
    }
}