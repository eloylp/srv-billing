package dao;

import model.BillingSerie;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface BillingSerieDao extends MongoRepository<BillingSerie, String> {


}
