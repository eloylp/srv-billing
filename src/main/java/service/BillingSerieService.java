package service;

import managers.BillingSerieManager;
import model.BillingSerie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class BillingSerieService {

    private final BillingSerieManager billingSerieManager;


    @Autowired
    public BillingSerieService(BillingSerieManager billingSerieManager) {
        this.billingSerieManager = billingSerieManager;
    }

    public BillingSerie create(BillingSerie billingSerie) {

        return new BillingSerie();
    }


    public List<BillingSerie> get() {

        return new ArrayList<>();
    }

}
