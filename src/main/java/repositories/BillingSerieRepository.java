package repositories;

import dao.BillingSerieDao;
import model.BillingSerie;
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
