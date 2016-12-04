package web;


import model.Invoice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by eloylp on 29/11/16.
 */

@RestController
class InvoiceController {

    @RequestMapping("/invoices")
    public Invoice invoice() {

        Invoice bill = new Invoice();

        return bill;
    }

}
