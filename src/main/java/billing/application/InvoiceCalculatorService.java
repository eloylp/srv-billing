package billing.application;


import billing.domain.BillingSerie;
import billing.domain.Delegation;
import billing.domain.Invoice;
import org.springframework.stereotype.Component;

@Component
public class InvoiceCalculatorService {


    public Invoice performBillingOperations(Invoice invoice, Delegation delegation, BillingSerie billingSerie) {

        return invoice;
    }
}
