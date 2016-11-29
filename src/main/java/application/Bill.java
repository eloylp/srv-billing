package application;

/**
 * Created by eloylp on 29/11/16.
 */
class Bill {

    private int billId;
    private String tax;

    public int getBillId() {
        return billId;
    }

    void setBillId(int billId) {
        this.billId = billId;
    }

    public String getTax() {
        return tax;
    }

    void setTax(String tax) {
        this.tax = tax;
    }
}
