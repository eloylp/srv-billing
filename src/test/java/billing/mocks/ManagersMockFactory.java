package billing.mocks;

import billing.manager.BillingSerieManager;
import billing.manager.DelegationManager;
import billing.manager.InvoiceManager;
import billing.model.Delegation;
import billing.model.Invoice;

import java.util.Objects;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by eloylp on 3/02/17.
 */
public class ManagersMockFactory {


    public BillingSerieManager getBillingSerieManager() {

        BillingSerieMockFactory billingSerieMockFactory = new BillingSerieMockFactory();

        BillingSerieManager billingSerieManager = mock(BillingSerieManager.class);
        when(billingSerieManager.getByName(anyString())).thenAnswer(invocationOnMock -> {

            String serieName = invocationOnMock.getArgumentAt(0, String.class);

            if (Objects.equals(serieName, "test_billing_serie_name")) {
                return billingSerieMockFactory.getBillingSerie();
            } else if (Objects.equals(serieName, "test_billing_serie_name_preinvoce")) {

                return billingSerieMockFactory.getProformaBillingSerie();
            } else {
                return null;
            }

        });

        return billingSerieManager;
    }

    public DelegationManager getDelegationManager() {

        DelegationManager delegationManager = mock(DelegationManager.class);
        when(delegationManager.getByName(anyString())).thenAnswer(invocationOnMock -> {

            String delegationName = invocationOnMock.getArgumentAt(0, String.class);

            if (delegationName == "delegation_name") {

                Delegation delegation = new DelegationMockFactory().getDelegation();
                return delegation;

            } else {
                return null;
            }

        });
        return delegationManager;
    }

    public InvoiceManager getInvoiceManager() {

        InvoiceManager invoiceManager = mock(InvoiceManager.class);
        when(invoiceManager.save(anyObject())).thenAnswer(invocationOnMock -> {
            return invocationOnMock.getArgumentAt(0, Invoice.class);
        });

        return invoiceManager;
    }

}
