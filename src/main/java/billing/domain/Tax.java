package billing.domain;


class Tax extends PositivePercentage {

    Tax(Name name, Value percent) throws BillingException {
        super(name, percent);
    }
}
