package repository;

import model.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by eloylp on 4/12/16.
 */
public interface InvoiceRepository extends MongoRepository<Invoice, String> {



}
