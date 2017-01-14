package repositories;

import dao.DelegationDao;
import model.Delegation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DelegationRepository {

    private final DelegationDao delegationDao;

    @Autowired
    public DelegationRepository(DelegationDao delegationDao) {
        this.delegationDao = delegationDao;
    }

    public Delegation getByName(String name) {
        Delegation delegation = this.delegationDao.findOne(name);

        return delegation;
    }

}
