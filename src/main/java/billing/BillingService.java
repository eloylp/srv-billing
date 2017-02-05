package billing;

import billing.exception.BillingDelegationNotFoundException;
import billing.manager.BillingSerieManager;
import billing.manager.DelegationManager;
import billing.manager.invoice.InvoiceManager;
import billing.model.BillingSerie;
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


    public Invoice makeBillingOperation(Invoice invoice) throws BillingDelegationNotFoundException {

        Delegation delegation = this.delegationManager.getByName(invoice.getDelegationName());

        if (delegation == null) {

            throw new BillingDelegationNotFoundException();
        }

        BillingSerie billingSerie;

        if (invoice.isPreInvoice()) {
            billingSerie = this.billingSerieManager.getByName(delegation.getProFormaBillingSerie());

        } else {
            billingSerie = this.billingSerieManager.getByName(delegation.getBillingSerie());
        }

        invoice.setBillingSerie(billingSerie);

        this.invoiceManager.performBillingOperations(invoice, delegation, billingSerie);
        this.invoiceManager.save(invoice);

        if (invoice.isMustBeMailed()) {
            this.invoiceManager.mailInvoice(invoice);
        }

        return invoice;
    }


    public Invoice makeInstallmentOperation(Invoice invoice) {

        return invoice;
    }


}
