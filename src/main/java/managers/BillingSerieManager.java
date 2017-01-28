package managers;

import model.BillingSerie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repositories.BillingSerieRepository;

import java.util.ArrayList;
import java.util.List;


@Component
public class BillingSerieManager {


    private final BillingSerieRepository billingSerieRepository;

    @Autowired
    public BillingSerieManager(BillingSerieRepository billingSerieRepository) {
        this.billingSerieRepository = billingSerieRepository;
    }

    public BillingSerie create(BillingSerie billingSerie) {

        return billingSerie;
    }

    public List<BillingSerie> getAll() {


        return new ArrayList<BillingSerie>();

    }

    public BillingSerie getIncrementedById(String id) {

        return new BillingSerie();
    }

    public BillingSerie getById() {

        return new BillingSerie();
    }

    public BillingSerie getByName(String name) {
        return new BillingSerie();
    }

}
