package billing.infrastructure.springweb;


import billing.application.BillingOperationService;
import billing.domain.Invoice;
import billing.domain.exception.BillingDelegationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
class BillingController {

    private BillingOperationService billingService;

    @Autowired
    BillingController(BillingOperationService billingService) {
        this.billingService = billingService;

    }

    @PreAuthorize("#oauth2.hasScope('billing')")
    @RequestMapping(value = "/billing", method = RequestMethod.POST)
    public Invoice billing() {

        Invoice invoice = new Invoice();
        try {
            billingService.makeBillingOperation(invoice);
        } catch (BillingDelegationNotFoundException e) {
            e.printStackTrace();
        }
        return invoice;
    }

}
