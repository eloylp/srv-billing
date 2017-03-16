package billing.infrastructure.springmongo;

import billing.domain.BillingSerie;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface BillingSerieDao extends MongoRepository<BillingSerie, String> {


}
