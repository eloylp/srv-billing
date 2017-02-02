package billing.dao;

import billing.model.Delegation;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface DelegationDao extends MongoRepository<Delegation, String> {


}
