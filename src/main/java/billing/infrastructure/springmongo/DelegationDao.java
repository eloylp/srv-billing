package billing.infrastructure.springmongo;

import billing.domain.Delegation;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface DelegationDao extends MongoRepository<Delegation, String> {


}
