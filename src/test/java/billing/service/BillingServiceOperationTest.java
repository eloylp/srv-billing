package billing.service;

import billing.BillingService;
import billing.exception.BillingDelegationNotFoundException;
import billing.manager.BillingSerieManager;
import billing.manager.DelegationManager;
import billing.manager.invoice.InvoiceManager;
import billing.model.Delegation;
import billing.model.Invoice;
import billing.service.mocks.InvoicePartsMockFactory;
import billing.service.mocks.ManagersMockFactory;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;


public class BillingServiceOperationTest {

    private BillingService billingService;

    private BillingSerieManager billingSerieManager;
    private DelegationManager delegationManager;
    private InvoiceManager invoiceManager;
    private Delegation delegation;

    private Invoice invoice;

    @Before
    public void SetUp() {

        InvoicePartsMockFactory fixtureFactory = new InvoicePartsMockFactory();
        this.invoice = fixtureFactory.getInvoice();

        this.delegation = mock(Delegation.class);

        when(this.delegation.getName()).thenReturn("delegation_name");

        ManagersMockFactory managersMockFactory = new ManagersMockFactory();
        this.billingSerieManager = managersMockFactory.getBillingSerieManager();
        this.delegationManager = managersMockFactory.getDelegationManager(this.delegation);
        this.invoiceManager = managersMockFactory.getInvoiceManager();

        this.billingService = new BillingService(
                this.billingSerieManager,
                this.delegationManager,
                this.invoiceManager);
    }

    @Test(expected = BillingDelegationNotFoundException.class)
    public void throwsExceptionWhenNoDelegationAvailable() throws BillingDelegationNotFoundException {

        this.invoice.setDelegationName("non_existing_delegation");
        this.billingService.makeBillingOperation(invoice);
        verify(this.delegationManager, atLeastOnce()).getByName(anyString());
    }

    @Test
    public void whenInvoiceIsProformProformSerieIsAdquired() throws BillingDelegationNotFoundException {
        this.invoice.setPreInvoice(true);
        Invoice resultantInvoice = this.billingService.makeBillingOperation(this.invoice);
        verify(this.delegation, atLeastOnce()).getProFormaBillingSerie();
        verify(this.delegation, never()).getBillingSerie();
    }

    @Test
    public void whenInvoiceIsRealRealSerieIsAdquired() throws BillingDelegationNotFoundException {

        this.invoice.setPreInvoice(false);
        Invoice resultantInvoice = this.billingService.makeBillingOperation(this.invoice);
        verify(this.delegation, atLeastOnce()).getBillingSerie();
        verify(this.delegation, never()).getProFormaBillingSerie();

    }

    @Test
    public void testThatInvoiceIsMailed() throws BillingDelegationNotFoundException {
        this.invoice.setMustBeMailed(true);
        this.billingService.makeBillingOperation(this.invoice);
        verify(this.invoiceManager, atLeastOnce()).mailInvoice(anyObject());
    }

    @Test
    public void testThatInvoiceIsNoMailed() throws BillingDelegationNotFoundException {
        this.invoice.setMustBeMailed(false);
        this.billingService.makeBillingOperation(this.invoice);
        verify(this.invoiceManager, never()).mailInvoice(anyObject());
    }
}
