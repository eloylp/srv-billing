package billing.service;

import billing.manager.BillingSerieManager;
import billing.manager.DelegationManager;
import billing.manager.InvoiceManager;
import billing.model.Delegation;
import billing.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BillingService {

    private final BillingSerieManager billingSerieManager;
    private final DelegationManager delegationManager;
    private final InvoiceManager invoiceManager;

    @Autowired
    public BillingService(BillingSerieManager billingSerieManager, DelegationManager delegationManager,
                          InvoiceManager invoiceManager) {
        this.billingSerieManager = billingSerieManager;
        this.delegationManager = delegationManager;
        this.invoiceManager = invoiceManager;
    }


    public Invoice makeBillingOperation(Invoice invoice) {

        Delegation delegation = this.delegationManager.getByName(invoice.getDelegationId());

        if (delegation == null) {

            //throw new Exception("ds");
        }

        return invoice;
    }


    public Invoice makeInstallmentOperation(Invoice invoice) {

        return invoice;
    }


}
