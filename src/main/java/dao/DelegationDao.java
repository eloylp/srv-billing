package dao;

import model.Delegation;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface DelegationDao extends MongoRepository<Delegation, String> {


}
