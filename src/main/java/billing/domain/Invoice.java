package billing.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
public class Invoice {

    @Id
    private String id;
    private String delegationName;

    private BillingSerie billingSerie;

    private Date billingDate;

    private boolean mustBeMailed;

    private String supplierName;
    private String supplierAddress;
    private String supplierIdentity;
    private String supplierEmail;
    private String supplierPhone;

    private String customerName;
    private String customerAddress;
    private String customerIdentity;
    private String customerEmail;
    private String customerPhone;

    private Date payment;
    private List<Discount> discounts;
    private List<Product> products;
    private String description;
    private boolean preInvoice;
    private List<Tax> taxes;

    private String pdf;
    private String html;

    private float subTotal;
    private float total;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
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
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Date getPayment() {
        return payment;
    }

    public void setPayment(Date payment) {
        this.payment = payment;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPreInvoice() {
        return preInvoice;
    }

    public void setPreInvoice(boolean preInvoice) {
        this.preInvoice = preInvoice;
    }

    public String getSupplierIdentity() {
        return supplierIdentity;
    }

    public void setSupplierIdentity(String supplierIdentity) {
        this.supplierIdentity = supplierIdentity;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone;
    }

    public String getCustomerIdentity() {
        return customerIdentity;
    }

    public void setCustomerIdentity(String customerIdentity) {
        this.customerIdentity = customerIdentity;
    }

    public List<Tax> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<Tax> taxes) {
        this.taxes = taxes;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getDelegationName() {
        return delegationName;
    }

    public void setDelegationName(String delegationName) {
        this.delegationName = delegationName;
    }

    public BillingSerie getBillingSerie() {
        return billingSerie;
    }

    public void setBillingSerie(BillingSerie billingSerie) {
        this.billingSerie = billingSerie;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public boolean isMustBeMailed() {
        return mustBeMailed;
    }

    public void setMustBeMailed(boolean mustBeMailed) {
        this.mustBeMailed = mustBeMailed;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
