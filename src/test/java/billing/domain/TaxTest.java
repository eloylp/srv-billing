package billing.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TaxTest {

    @ParameterizedTest(name = "{index} Taxes must accept this positive values: {0}")
    @ValueSource(doubles = {-0.00, 0.00, 0.01, 1.33, 0.0001, 1.0, 345.67})
    void testAcceptedValues(Double value) throws BillingException {
        new Tax("tax", new Value(value));
    }

    @ParameterizedTest(name = "{index} Taxes must not accept negative values like: {0}")
    @ValueSource(doubles = {-0.01, -1.0, -345.67})
    void testNotAcceptedValues(Double value) {
        assertThrows(NegativeNumberException.class, () -> new Tax("tax", new Value(value)));
    }
}