package main;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by eloylp on 29/11/16.
 */

@RestController
class TestController {

    @RequestMapping("/bill")
    public Bill bill() {

        Bill bill = new Bill();
        bill.setBillId(23);
        bill.setTax("TAX");

        return bill;
    }

}
