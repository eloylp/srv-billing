package billing.infrastructure.springmongo;

import billing.domain.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface InvoiceDao extends MongoRepository<Invoice, String> {


}
