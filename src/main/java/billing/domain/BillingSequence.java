package billing.domain;


class BillingSequence {


    private Uuid uuid;
    private Name name;

    private String prefix;
    private String suffix;
    private String delimiter;
    private AutoIncrement number;

    BillingSequence(Name name, String prefix, String suffix, String delimiter) throws InvalidNameException {

        this.setName(name);
        this.setPrefix(prefix);
        this.setSuffix(suffix);
        this.setDelimiter(delimiter);
        this.number = new AutoIncrement("1");
        this.uuid = new Uuid();

    }

    private void setPrefix(String prefix) {
        this.prefix = prefix.toUpperCase().replaceAll("\\s+", "");
    }

    private void setSuffix(String suffix) {
        this.suffix = suffix.toUpperCase().replaceAll("\\s+", "");
    }

    private void setDelimiter(String delimiter) {
        this.delimiter = delimiter.toUpperCase().replaceAll("\\s+", "");
    }

    @Override
    public String toString() {
        return String.join(delimiter, prefix, number.toString(), suffix);
    }

    String getPrefix() {
        return prefix;
    }

    String getSuffix() {
        return suffix;
    }

    String getDelimiter() {
        return delimiter;
    }

    AutoIncrement getNumber() {
        return number;
    }

    public void setName(Name name) throws InvalidNameException {
        if (name == null) {
            throw new InvalidNameException("Name must be not null");
        }
        this.name = name;
    }

    Uuid getUuid() {
        return uuid;
    }

    public Name getName() {
        return name;
    }
}
