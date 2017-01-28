package service;


import managers.InvoiceManager;
import model.Invoice;
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
