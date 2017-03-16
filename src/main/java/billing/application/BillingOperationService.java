package billing.application;

import billing.domain.BillingSerie;
import billing.domain.Delegation;
import billing.domain.Invoice;
import billing.domain.exception.BillingDelegationNotFoundException;
import billing.repository.BillingSerieRepository;
import billing.repository.DelegationRepository;
import billing.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BillingOperationService {

    private final BillingSerieRepository billingSerieRepository;
    private final DelegationRepository delegationRepository;
    private final InvoiceCalculatorService invoiceCalculatorService;
    private final InvoiceRepository invoiceRepository;

    @Autowired
    public BillingOperationService(BillingSerieRepository billingSerieRepository,
                                   DelegationRepository delegationRepository,
                                   InvoiceCalculatorService invoiceCalculatorService,
                                   InvoiceRepository invoiceRepository) {

        this.billingSerieRepository = billingSerieRepository;
        this.delegationRepository = delegationRepository;
        this.invoiceCalculatorService = invoiceCalculatorService;
        this.invoiceRepository = invoiceRepository;
    }


    public Invoice makeBillingOperation(Invoice invoice) throws BillingDelegationNotFoundException {

        Delegation delegation = this.delegationRepository.getByName(invoice.getDelegationName());

        if (delegation == null) {

            throw new BillingDelegationNotFoundException();
        }

        BillingSerie billingSerie;

        if (invoice.isPreInvoice()) {
            billingSerie = this.billingSerieRepository.getByName(delegation.getProFormaBillingSerie());

        } else {
            billingSerie = this.billingSerieRepository.getByName(delegation.getBillingSerie());
        }

        invoice.setBillingSerie(billingSerie);

        Invoice calculatedInvoice = this.invoiceCalculatorService.performBillingOperations(invoice, delegation, billingSerie);

        this.invoiceRepository.save(calculatedInvoice);

        return invoice;
    }


}
