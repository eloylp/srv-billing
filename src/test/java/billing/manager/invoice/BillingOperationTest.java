package billing.manager.invoice;

import billing.model.Invoice;
import billing.service.mocks.InvoicePartsMockFactory;
import org.junit.Before;
import org.junit.Test;

public class BillingOperationTest {

    private InvoicePartsMockFactory invoicePartsMockFactory;
    private Invoice invoice;
    private BillingOperation billingOperation;

    BillingOperationTest(){
        this.invoicePartsMockFactory = new InvoicePartsMockFactory();
        this.billingOperation = new BillingOperation();
    }

    @Before
    public void setUp() {
        this.invoice = this.invoicePartsMockFactory.getInvoice();
    }

    @Test
    public void testTotalsAreCalculated() {

        Invoice resultantInvoice = this.billingOperation.make(this.invoice);

        //assertEquals(resultantInvoice.getClass());

    }


}
