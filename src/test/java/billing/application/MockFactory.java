package billing.application;

import billing.domain.BillingSerieMockFactory;
import billing.domain.Delegation;
import billing.domain.Invoice;
import billing.repository.BillingSerieRepository;
import billing.repository.DelegationRepository;
import billing.repository.InvoiceRepository;

import java.util.Objects;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class MockFactory {


    public BillingSerieRepository getBillingSerieRepository() {

        BillingSerieMockFactory billingSerieMockFactory = new BillingSerieMockFactory();

        BillingSerieRepository billingSerieRespository = mock(BillingSerieRepository.class);
        when(billingSerieRespository.getByName(anyString())).thenAnswer(invocationOnMock -> {

            String serieName = invocationOnMock.getArgumentAt(0, String.class);

            if (Objects.equals(serieName, "test_billing_serie_name")) {
                return billingSerieMockFactory.getBillingSerie();
            } else if (Objects.equals(serieName, "test_billing_serie_name_preinvoce")) {

                return billingSerieMockFactory.getProformaBillingSerie();
            } else {
                return null;
            }

        });

        return billingSerieRespository;
    }

    public DelegationRepository getDelegationRepository(Delegation delegation) {

        DelegationRepository delegationRepository = mock(DelegationRepository.class);
        when(delegationRepository.getByName(anyString())).thenAnswer(invocationOnMock -> {

            String delegationName = invocationOnMock.getArgumentAt(0, String.class);

            if (Objects.equals(delegationName, delegation.getName())) {

                return delegation;

            } else {
                return null;
            }

        });
        return delegationRepository;
    }

    public InvoiceRepository getInvoiceRepository() {

        InvoiceRepository invoiceRepository = mock(InvoiceRepository.class);
        when(invoiceRepository.save(anyObject()))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArgumentAt(0, Invoice.class));

        return invoiceRepository;
    }

    public InvoiceCalculatorService getInvoiceCalculatorService() {

        InvoiceCalculatorService invoiceCalculatorService = mock(InvoiceCalculatorService.class);

        when(invoiceCalculatorService.performBillingOperations(anyObject(), anyObject(), anyObject()))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArgumentAt(0, Invoice.class));

        return invoiceCalculatorService;
    }

}
