
import model.BillingSerie;
import model.Invoice;
import org.junit.Test;
import repositories.BillingSerieRepository;
import repositories.InvoiceRepository;
import service.BillingService;

import java.util.Date;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class BillingServiceTest {


    private BillingService getBillingServiceFixture() {

        InvoiceRepository invoiceRepositoryStub = mock(InvoiceRepository.class);
        when(invoiceRepositoryStub.save(anyObject())).thenAnswer(invocationOnMock -> {
            Invoice invoice = invocationOnMock.getArgumentAt(0, Invoice.class);
            return invoice;
        });

        BillingSerieRepository billingSerieRepositoryStub = mock(BillingSerieRepository.class);
        when(billingSerieRepositoryStub.getByName(anyString())).thenAnswer(invocationOnMock -> {
            String serieName = invocationOnMock.getArgumentAt(0, String.class);
            if (Objects.equals(serieName, "TEST_SERIE_NAME")) {
                BillingSerie billingSerie = new BillingSerie();
                billingSerie.setAutoIncremental(1);
                billingSerie.setId(serieName);
                billingSerie.setPrefix("BS");
                billingSerie.setHasYear(true);
                billingSerie.setSuffix("SBS");

                return billingSerie;
            } else {
                return null;
            }

        });

        return new BillingService(invoiceRepositoryStub, billingSerieRepositoryStub);
    }

    @Test
    public void billingOperation() {
        BillingService billingService = getBillingServiceFixture();

        Invoice invoice = new Invoice();
        invoice.setDescription("This is a description");
        invoice.setCustomerAddress("Customer address");
        invoice.setBillingDate(new Date());

        Invoice invoiceret = billingService.makeBillingOperation(invoice);

        assertEquals(invoice.getDescription(), invoiceret.getDescription());
    }
}
