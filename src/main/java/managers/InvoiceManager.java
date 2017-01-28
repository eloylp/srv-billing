package managers;

import model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repositories.InvoiceRepository;


@Component
public class InvoiceManager {

    private final MailManager mailManager;
    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceManager(MailManager mailManager, InvoiceRepository invoiceRepository) {
        this.mailManager = mailManager;
        this.invoiceRepository = invoiceRepository;
    }

    public Invoice save(Invoice invoice) {

        return invoice;
    }


}
