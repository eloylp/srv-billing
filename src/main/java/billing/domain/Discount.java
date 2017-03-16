package billing.domain;


public class Discount {


    private String name;
    private double percent;

    public Discount() {

    }

    public Discount(String name, double percent) {

        this.setName(name);
        this.setPercent(percent);

    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
