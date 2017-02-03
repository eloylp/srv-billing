package web;


import billing.BillingService;
import billing.exception.BillingException;
import billing.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
class BillingController {

    private BillingService billingService;

    @Autowired
    BillingController(BillingService billingService) {
        this.billingService = billingService;

    }

    @PreAuthorize("#oauth2.hasScope('billing')")
    @RequestMapping(value = "/billing", method = RequestMethod.POST)
    public Invoice billing() {

        Invoice invoice = new Invoice();
        try {
            billingService.makeBillingOperation(invoice);
        } catch (BillingException e) {
            e.printStackTrace();
        }
        return invoice;
    }

    @PreAuthorize("#oauth2.hasScope('billing')")
    @RequestMapping(value = "/installment", method = RequestMethod.POST)
    public Invoice installment() {

        Invoice invoice = new Invoice();
        billingService.makeInstallmentOperation(invoice);
        return invoice;
    }

}
