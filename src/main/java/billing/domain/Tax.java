package billing.domain;


class Tax extends PositivePercentage {

    Tax(String name, Value percent) throws BillingException {
        super(name, percent);

    }
}
