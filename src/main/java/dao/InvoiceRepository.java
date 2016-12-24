package dao;

import model.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface InvoiceRepository extends MongoRepository<Invoice, String> {



}
