package billing.domain;


public class Tax {

    private String name;
    private Value percent;

    Tax(String name, Value percent) throws BillingException {
        this.setName(name);
        this.setPercent(percent);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Value getPercent() {
        return percent;
    }

    private void setPercent(Value percent) throws BillingException {
        checkNonNegativeValue(percent);
        this.percent = percent;
    }

    private void checkNonNegativeValue(Value percent) throws BillingException {
        if (percent.compareTo(new Value(0)) < 0) {
            throw new NegativeNumberException(percent);
        }
    }

}
