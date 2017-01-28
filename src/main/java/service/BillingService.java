package service;

import managers.BillingSerieManager;
import managers.DelegationManager;
import managers.InvoiceManager;
import model.Invoice;
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

        return invoice;
    }


    public Invoice makeInstallmentOperation(Invoice invoice) {

        return invoice;
    }


}
