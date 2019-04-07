package billing.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

class Value extends BigDecimal {

    Value(String val) {
        super(val);
    }

    Value(double val) {
        super(val);
    }

    public Value(BigInteger val) {
        super(val);
    }

    Value(int val) {
        super(val);
    }

    public Value(long val) {
        super(val);
    }
}
