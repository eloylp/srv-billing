package billing.manager.invoice;

import billing.model.BillingSerie;
import billing.model.Delegation;
import billing.model.Invoice;
import billing.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


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

    public boolean mailInvoice(Invoice invoice) {

        this.mailManager.mailHtml("sd");

        return true;
    }

    /// TODO PERHAPS MAY BE IN ONE OBJECT ? INTEAD OF THREE PARAMS  ?
    public Invoice performBillingOperations(Invoice invoice, Delegation delegation, BillingSerie billingSerie) {

        return invoice;

    }


}
