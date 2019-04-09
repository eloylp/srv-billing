package billing.domain;

import java.math.BigInteger;

class AutoIncrement extends BigInteger {
    AutoIncrement(String val) {
        super(val);
    }
}
