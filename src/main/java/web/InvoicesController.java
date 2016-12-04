package web;


import model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.BillingService;


@RestController
class InvoicesController {

    private BillingService billingService;

    @Autowired
    InvoicesController(BillingService billingService) {
        this.billingService = billingService;

    }

    @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    public Invoice invoice() {

        Invoice invoice = new Invoice();

        billingService.makeBillingOperation(invoice);
        return invoice;
    }

}
