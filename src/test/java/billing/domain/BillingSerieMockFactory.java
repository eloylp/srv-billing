package billing.domain;


public class BillingSerieMockFactory {


    public BillingSerie getBillingSerie() {

        BillingSerie billingSerie = new BillingSerie();
        billingSerie.setAutoIncremental(1);
        billingSerie.setName("test_billing_serie_name");
        billingSerie.setId("test_billing_serie_name");
        billingSerie.setPrefix("prefix");
        billingSerie.setHasYear(true);
        billingSerie.setSuffix("suffix");k

        return billingSerie;

    }

    public BillingSerie getProformaBillingSerie() {

        BillingSerie billingSerie = new BillingSerie();
        billingSerie.setAutoIncremental(1);
        billingSerie.setName("test_billing_serie_name_preinvoce");
        billingSerie.setId("test_billing_serie_name_preinvoce");
        billingSerie.setPrefix("PREINVOICE-");
        billingSerie.setSuffix("suffix");
        billingSerie.setHasYear(true);

        return billingSerie;
    }

}
