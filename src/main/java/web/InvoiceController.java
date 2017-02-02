package web;


import billing.model.Invoice;
import billing.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
class InvoiceController {

    private InvoiceService invoiceService;

    @Autowired
    InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;

    }

    @PreAuthorize("#oauth2.hasScope('read')")
    @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    public Invoice invoice() {

        return invoiceService.getOne();
    }

}
