package dao;

import model.Delegation;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface DelegationRepository extends MongoRepository<Delegation, String> {


}
