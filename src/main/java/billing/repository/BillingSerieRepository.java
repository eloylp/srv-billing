package billing.repository;

import billing.domain.BillingSerie;
import billing.infrastructure.springmongo.BillingSerieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BillingSerieRepository {

    private final BillingSerieDao billingSerieDao;


    @Autowired
    public BillingSerieRepository(BillingSerieDao billingSerieDao) {
        this.billingSerieDao = billingSerieDao;
    }

    public BillingSerie getByName(String name) {

        return billingSerieDao.findOne(name);
    }
}
