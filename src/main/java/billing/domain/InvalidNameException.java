package billing.domain;

class InvalidNameException extends BillingException {
    InvalidNameException(String name) {
        super("This name do not accomplish business rules: " + name);

    }
}
