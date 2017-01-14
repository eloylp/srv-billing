import model.Discount;
import model.Invoice;
import model.Product;
import model.Tax;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class FixtureFactory {

    public Discount getDiscount() {
        Discount discount = new Discount();
        discount.setPercent(5.00);
        discount.setTitle("A 5% general discount.");

        return discount;
    }

    public Product getProductPencil() {
        Product pencil = new Product();
        pencil.setId(12);
        pencil.setFamily("office");
        pencil.setDescription("A great pencil.");
        pencil.setPrice(15.50);
        pencil.setDiscount(getDiscount());

        return pencil;

    }

    public Product getProductDrone() {
        Product drone = new Product();
        drone.setId(12);
        drone.setFamily("flight");
        drone.setDescription("A great drone.");
        drone.setPrice(75.50);
        drone.setDiscount(getDiscount());

        return drone;
    }

    public Tax getIvaTax() {

        Tax tax = new Tax();
        tax.setPercent(21.00);
        tax.setName("IVA");

        return tax;
    }

    public Tax getTrxTax() {

        Tax tax = new Tax();
        tax.setPercent(3.00);
        tax.setName("TRX");

        return tax;
    }

    public Invoice getInvoice() {
        Invoice invoice = new Invoice();
        invoice.setId("af123");
        invoice.setDescription("description");
        invoice.setBillingDate(new Date());
        invoice.setDelegationId("delegation_id");
        invoice.setPreInvoice(true);
        invoice.setPayment(new Date());

        List products = new ArrayList();
        products.add(getProductDrone());
        products.add(getProductPencil());
        invoice.setProducts(products);

        List taxes = new ArrayList();
        taxes.add(getIvaTax());
        taxes.add(getTrxTax());
        invoice.setTaxes(taxes);

        invoice.setCustomerName("customer_name");
        invoice.setCustomerEmail("info@twiggy.xyz");
        invoice.setCustomerAddress("customer_address");
        invoice.setCustomerIdentity("12345678B");
        invoice.setCustomerPhone("900000000");


        invoice.setSupplierName("supplier_name");
        invoice.setSupplierEmail("supplier@email.com");
        invoice.setSupplierAddress("supplier_address");
        invoice.setSupplierIdentity("12345678M");
        invoice.setSupplierPhone("981210918");

        return invoice;
    }
}
