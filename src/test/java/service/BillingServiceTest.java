package service;

import managers.BillingSerieManager;
import managers.DelegationManager;
import managers.InvoiceManager;
import model.BillingSerie;
import model.Delegation;
import model.Invoice;
import org.junit.Test;

import java.util.Objects;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class BillingServiceTest {


    private BillingService getBillingServiceStub() {

        InvoiceManager invoiceManager = mock(InvoiceManager.class);
        when(invoiceManager.save(anyObject())).thenAnswer(invocationOnMock -> {
            return invocationOnMock.getArgumentAt(0, Invoice.class);
        });

        DelegationManager delegationManager = mock(DelegationManager.class);
        when(delegationManager.getByName(anyString())).thenAnswer(invocationOnMock -> {

            return new Delegation();
        });

        BillingSerieManager billingSerieManager = mock(BillingSerieManager.class);
        when(billingSerieManager.getByName(anyString())).thenAnswer(invocationOnMock -> {

            String serieName = invocationOnMock.getArgumentAt(0, String.class);

            if (Objects.equals(serieName, "test_billing_serie_name")) {
                BillingSerie billingSerie = new BillingSerie();
                billingSerie.setAutoIncremental(1);
                billingSerie.setId(serieName);
                billingSerie.setPrefix("prefix");
                billingSerie.setHasYear(true);
                billingSerie.setSuffix("suffix");

                return billingSerie;
            } else if (Objects.equals(serieName, "test_billing_serie_name_preinvoce")) {
                BillingSerie billingSerie = new BillingSerie();
                billingSerie.setAutoIncremental(1);
                billingSerie.setId(serieName);
                billingSerie.setPrefix("PREINVOICE-");
                billingSerie.setHasYear(true);
                return billingSerie;

            } else {
                return null;
            }

        });

        return new BillingService(billingSerieManager, delegationManager, invoiceManager);
    }

    @Test
    public void billingOperationTreatsPreInvoiceAsIt() {

    }
}
