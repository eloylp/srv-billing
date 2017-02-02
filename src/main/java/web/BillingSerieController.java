package web;


import billing.model.BillingSerie;
import billing.service.BillingSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
class BillingSerieController {

    private BillingSerieService billingSerieService;

    @Autowired
    BillingSerieController(BillingSerieService billingSerieService) {
        this.billingSerieService = billingSerieService;
    }

    @PreAuthorize("#oauth2.hasScope('read admin')")
    @RequestMapping(value = "/billingSeries", method = RequestMethod.GET)
    public List<BillingSerie> getSeries() {

        return this.billingSerieService.get();
    }

    @PreAuthorize("#oauth2.hasScope('admin')")
    @RequestMapping(value = "/billingSeries", method = RequestMethod.POST)
    public BillingSerie createSerie(BillingSerie billingSerie) {

        return billingSerie;
    }

}
