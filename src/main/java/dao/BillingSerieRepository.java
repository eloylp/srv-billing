package dao;

import model.BillingSerie;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface BillingSerieRepository extends MongoRepository<BillingSerie, String> {


}
