package billing.domain;

class Name {

    private String value;

    Name(String value) throws InvalidNameException {
        checkValue(value);
        this.value = value;
    }

    private void checkValue(String value) throws InvalidNameException {
        if (value == null || value.length() < 3) {
            throw new InvalidNameException(value);
        }
    }

    public String getValue() {
        return value;
    }
}
