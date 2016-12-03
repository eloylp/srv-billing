package model;

/**
 * Created by eloylp on 29/11/16.
 */
public class Bill {

    private int billId;
    private String tax;

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }
}
