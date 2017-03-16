package billing.application;

import billing.domain.Delegation;
import billing.domain.Invoice;
import billing.domain.InvoicePartsMockFactory;
import billing.domain.exception.BillingDelegationNotFoundException;
import billing.repository.BillingSerieRepository;
import billing.repository.DelegationRepository;
import billing.repository.InvoiceRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;


public class BillingServiceOperationTest {

    private BillingOperationService billingService;

    private BillingSerieRepository billingSerieRepository;
    private DelegationRepository delegationRepository;
    private InvoiceRepository invoiceRepository;
    private InvoiceCalculatorService invoiceCalculatorService;
    private Delegation delegation;

    private Invoice invoice;

    @Before
    public void SetUp() {

        InvoicePartsMockFactory fixtureFactory = new InvoicePartsMockFactory();
        this.invoice = fixtureFactory.getInvoice();

        this.delegation = mock(Delegation.class);

        when(this.delegation.getName()).thenReturn("delegation_name");

        MockFactory managersMockFactory = new MockFactory();
        this.billingSerieRepository = managersMockFactory.getBillingSerieRepository();
        this.delegationRepository = managersMockFactory.getDelegationRepository(this.delegation);
        this.invoiceRepository = managersMockFactory.getInvoiceRepository();
        this.invoiceCalculatorService = managersMockFactory.getInvoiceCalculatorService();

        this.billingService = new BillingOperationService(
                this.billingSerieRepository,
                this.delegationRepository,
                this.invoiceCalculatorService,
                this.invoiceRepository);
    }

    @Test(expected = BillingDelegationNotFoundException.class)
    public void throwsExceptionWhenNoDelegationAvailable() throws BillingDelegationNotFoundException {

        this.invoice.setDelegationName("non_existing_delegation");
        this.billingService.makeBillingOperation(invoice);
        verify(this.delegationRepository, atLeastOnce()).getByName(anyString());
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

}
