package billing.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PositivePercentageTest {

    class ConcretePercentage extends PositivePercentage {
        ConcretePercentage(Name name, Value percent) throws NegativeNumberException {
            super(name, percent);
        }
    }

    @ParameterizedTest(name = "{index} Percentage must accept this positive values: {0}")
    @ValueSource(doubles = {-0.00, 0.00, 0.01, 1.33, 0.0001, 1.0, 345.67})
    void testAcceptedValues(Double value) throws NegativeNumberException, InvalidNameException {
        new ConcretePercentage(new Name("name"), new Value(value));

    }

    @ParameterizedTest(name = "{index} Percentage must not accept negative values like: {0}")
    @ValueSource(doubles = {-0.01, -1.0, -345.67})
    void testNotAcceptedValues(Double value) {
        assertThrows(NegativeNumberException.class, () -> new ConcretePercentage(new Name("name"), new Value(value)));
    }

    @Test
    void testNullDiscarded() {
        assertThrows(NegativeNumberException.class, () -> new ConcretePercentage(new Name("name"), null));
    }
}