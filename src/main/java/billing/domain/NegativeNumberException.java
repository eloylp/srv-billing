package billing.domain;

class NegativeNumberException extends BillingException {

    NegativeNumberException(Value value) {
        super("This number " + value + " cannot be negative in this context.");
    }
}
