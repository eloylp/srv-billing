package billing.domain;

abstract class PositivePercentage {


    private Uuid uuid;
    private Name name;
    private Value percent;

    PositivePercentage(Name name, Value percent) throws NegativeNumberException {
        this.setName(name);
        this.setPercent(percent);
        this.uuid = new Uuid();
    }

    public Name getName() {
        return name;
    }

    private void setName(Name name) {
        this.name = name;
    }

    public Value getPercent() {
        return percent;
    }

    private void setPercent(Value percent) throws NegativeNumberException {
        checkNonNegativeValue(percent);
        this.percent = percent;
    }

    private void checkNonNegativeValue(Value percent) throws NegativeNumberException {
        if (percent == null || percent.compareTo(new Value(0)) < 0) {
            throw new NegativeNumberException(percent);
        }
    }

    Uuid getUuid() {
        return uuid;
    }
}
