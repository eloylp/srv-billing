
import model.BillingSerie;
import model.Invoice;
import org.junit.Test;
import repositories.BillingSerieRepository;
import repositories.InvoiceRepository;
import service.BillingService;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class BillingServiceTest {


    private BillingService getBillingServiceStub() {

        InvoiceRepository invoiceRepositoryStub = mock(InvoiceRepository.class);
        when(invoiceRepositoryStub.save(anyObject())).thenAnswer(invocationOnMock -> {
            Invoice invoice = invocationOnMock.getArgumentAt(0, Invoice.class);
            return invoice;
        });

        BillingSerieRepository billingSerieRepositoryStub = mock(BillingSerieRepository.class);
        when(billingSerieRepositoryStub.getByName(anyString())).thenAnswer(invocationOnMock -> {

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

        return new BillingService(invoiceRepositoryStub, billingSerieRepositoryStub);
    }

    @Test
    public void billingOperationTreatsPreInvoiceAsIt() {

        BillingService billingService = getBillingServiceStub();
        FixtureFactory fixtureFactory = new FixtureFactory();
        Invoice invoice = fixtureFactory.getInvoice();
        BillingSerie billingSerie = new BillingSerie();
        billingSerie.setName("test_billing_serie_name_preinvoce");
        invoice.setBillingSerie(billingSerie);

        Invoice preinvoice = billingService.makeBillingOperation(invoice);

        assertEquals(preinvoice.getBillingSerie().getPrefix(), "PREINVOICE-");
    }
}
