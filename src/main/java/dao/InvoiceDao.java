package dao;

import model.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface InvoiceDao extends MongoRepository<Invoice, String> {


}
