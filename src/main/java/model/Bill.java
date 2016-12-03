package model;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by eloylp on 29/11/16.
 */

public class Bill {

    @Id
    private String id;

    private Date date;
    private int vatId;
    private String supplierName;
    private String supplierAddress;
    private String CustomerName;
    private String CustomerAddress;
    private Date payment;
    private int vatRate;
    private double vatAmount;
    private Exempt[] exempts;
    private Product[] products;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getVatId() {
        return vatId;
    }

    public void setVatId(int vatId) {
        this.vatId = vatId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerAddress() {
        return CustomerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        CustomerAddress = customerAddress;
    }

    public Date getPayment() {
        return payment;
    }

    public void setPayment(Date payment) {
        this.payment = payment;
    }

    public int getVatRate() {
        return vatRate;
    }

    public void setVatRate(int vatRate) {
        this.vatRate = vatRate;
    }

    public double getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(double vatAmount) {
        this.vatAmount = vatAmount;
    }

    public Exempt[] getExempts() {
        return exempts;
    }

    public void setExempts(Exempt[] exempts) {
        this.exempts = exempts;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
}
