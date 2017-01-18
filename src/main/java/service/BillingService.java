package service;

import model.BillingSerie;
import model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repositories.BillingSerieRepository;
import repositories.InvoiceRepository;


@Component
public class BillingService {

    private InvoiceRepository invoiceRepository;
    private BillingSerieRepository billingSerieRepository;

    @Autowired
    public BillingService(InvoiceRepository invoiceRepository, BillingSerieRepository billingSerieRepository) {
        this.invoiceRepository = invoiceRepository;
        this.billingSerieRepository = billingSerieRepository;
    }

    public Invoice makeBillingOperation(Invoice invoice) {


        BillingSerie billingSerie = this.billingSerieRepository.getByName(invoice.getBillingSerie().getName());

        invoice.setBillingSerie(billingSerie);

        return invoice;
    }


}
