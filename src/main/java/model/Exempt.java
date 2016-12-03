package model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

/**
 * Created by eloylp on 4/12/16.
 */

public class Exempt {
    private int id;

    private double discount;

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
