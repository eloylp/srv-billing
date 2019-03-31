package billing.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eloylp on 3/02/17.
 */
public class DelegationMockFactory {


    public Delegation getDelegation() {

        Delegation delegation = new Delegation();

        delegation.setId("delegation_id");
        delegation.setName("delegation_name");
        delegation.setEmail("delgation@email.com");
        delegation.setIdentity("123456678B");
        delegation.setActive(true);
        delegation.setAddress("delegation_address");
        delegation.setBillingSerie("test_billing_serie_name");
        delegation.setProFormaBillingSerie("test_billing_serie_name_preinvoce");
        delegation.setTelephone("delegation_tlf");
        delegation.setInvoiceTemplate("delegation_invoice_template");

        List<Tax> taxes = new ArrayList<>();
        taxes.add(new Tax("IVA", 21.00));
        delegation.setTaxes(taxes);

        List<Discount> discounts = new ArrayList<>();
        discounts.add(new Discount("discount_name", 5.00));
        delegation.setDiscounts(discounts);
        return delegation;

    }


}