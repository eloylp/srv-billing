package service;

import model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import dao.InvoiceRepository;
import org.springframework.stereotype.Component;


@Component
public class BillingService {

    private InvoiceRepository invoiceRepository;

    @Autowired
    BillingService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Invoice makeBillingOperation(Invoice invoice) {

        invoiceRepository.save(invoice);

        return invoice;
    }


}
