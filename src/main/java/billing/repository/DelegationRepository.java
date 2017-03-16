package billing.repository;

import billing.domain.Delegation;
import billing.infrastructure.springmongo.DelegationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class DelegationRepository {

    private final DelegationDao delegationDao;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public DelegationRepository(DelegationDao delegationDao, MongoTemplate mongoTemplate) {
        this.delegationDao = delegationDao;
        this.mongoTemplate = mongoTemplate;
    }

    public Delegation getByName(String name) {
        Delegation delegation = this.delegationDao.findOne(name);

        return delegation;
    }

    public Delegation create(Delegation delegation)
    {

        return this.delegationDao.insert(delegation);
    }

    public Delegation increment(Delegation delegation){

        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(delegation.getId()));
        Update update = new Update();
        update.set("autoIncremental", +1);
        Delegation updatedDelegation = mongoTemplate.findAndModify(query, update, Delegation.class);
        return updatedDelegation;
    }

}
