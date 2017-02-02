package billing.service;


import billing.manager.InvoiceManager;
import billing.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InvoiceService {

    private final InvoiceManager invoiceManager;

    @Autowired
    public InvoiceService(InvoiceManager invoiceManager) {
        this.invoiceManager = invoiceManager;
    }

    public Invoice getOne() {

        return new Invoice();

    }


}
