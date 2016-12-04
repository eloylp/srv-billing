package dao;

import model.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by eloylp on 4/12/16.
 */
public interface InvoiceRepository extends MongoRepository<Invoice, String> {



}
