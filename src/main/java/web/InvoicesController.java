package web;


import model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.BillingService;


@RestController
class InvoicesController {

    private BillingService billingService;

    @Value("${srv.hdd.folder}")
    private String hddurl;


    @Autowired
    InvoicesController(BillingService billingService) {
        this.billingService = billingService;

    }
    @PreAuthorize("#oauth2.hasScope('invoice_review')")
    @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    public Invoice invoice() {

        Invoice invoice = new Invoice();
        invoice.setCustomerAddress(this.hddurl);

        billingService.makeBillingOperation(invoice);
        return invoice;
    }

}
