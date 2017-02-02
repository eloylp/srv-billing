package billing.dao;

import billing.model.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface InvoiceDao extends MongoRepository<Invoice, String> {


}
