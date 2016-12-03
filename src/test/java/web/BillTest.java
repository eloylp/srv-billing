package web;

import model.Bill;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by eloylp on 29/11/16.
 */


public class BillTest {

    private Bill bill;

    @Before
    public void setUp() throws Exception {

        this.bill = new Bill();
    }

    @Test
    public void getBillId() throws Exception {

        this.bill.setBillId(12);
        assertEquals(12, this.bill.getBillId());

    }

    @Test
    public void getTax() throws Exception {
        this.bill.setTax("Tax");
        assertEquals("Tax", this.bill.getTax());
    }

}