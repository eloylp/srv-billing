package billing.domain;


public class Tax {


    private String name;
    private double percent;

    public Tax() {

    }

    public Tax(String name, double percent) {
        this.setName(name);
        this.setPercent(percent);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

}
