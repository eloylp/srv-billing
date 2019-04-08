package billing.domain;


class Discount extends PositivePercentage {

    Discount(Name name, Value percent) throws BillingException {
        super(name, percent);
    }
}
