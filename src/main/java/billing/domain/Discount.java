package billing.domain;


class Discount extends PositivePercentage {

    Discount(String name, Value percent) throws BillingException {
        super(name, percent);
    }
}
