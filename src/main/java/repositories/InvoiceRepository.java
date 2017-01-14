package repositories;

import dao.InvoiceDao;
import model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class InvoiceRepository {

    private final InvoiceDao invoiceDao;

    @Autowired
    public InvoiceRepository(InvoiceDao invoiceDao) {
        this.invoiceDao = invoiceDao;
    }

    public Invoice save(Invoice invoice) {

        this.invoiceDao.save(invoice);

        return invoice;

    }

}
