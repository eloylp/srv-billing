package billing.service;

import billing.BillingService;
import billing.exception.BillingException;
import billing.mocks.InvoicePartsMockFactory;
import billing.mocks.ManagersMockFactory;
import billing.model.Invoice;
import org.junit.Test;


public class BillingServiceOperationTest {


    @Test(expected = BillingException.class)
    public void throwsExceptionWhenNoDelegationAvailable() throws BillingException {

        ManagersMockFactory managersMockFactory = new ManagersMockFactory();

        InvoicePartsMockFactory fixtureFactory = new InvoicePartsMockFactory();
        BillingService billingService = new BillingService(
                managersMockFactory.getBillingSerieManager(),
                managersMockFactory.getDelegationManager(),
                managersMockFactory.getInvoiceManager());

        Invoice invoice = fixtureFactory.getInvoice();

        Invoice result = billingService.makeBillingOperation(invoice);

    }
}
