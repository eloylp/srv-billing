package billing.domain;


class BillingSequence {

    private String prefix;
    private String suffix;
    private String delimiter;
    private AutoIncrement number;

    BillingSequence(String prefix, String suffix, String delimiter) {

        this.setPrefix(prefix);
        this.setSuffix(suffix);
        this.setDelimiter(delimiter);
        this.number = new AutoIncrement("1");
    }

    private void setPrefix(String prefix) {
        this.prefix = prefix.toUpperCase().replaceAll("\\s+","");
    }

    private void setSuffix(String suffix) {
        this.suffix = suffix.toUpperCase().replaceAll("\\s+","");
    }

    private void setDelimiter(String delimiter) {
        this.delimiter = delimiter.toUpperCase().replaceAll("\\s+","");
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
}
