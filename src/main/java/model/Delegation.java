package model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Delegation {

    @Id
    private String id;

    private String name;
    private String identity;
    private String address;
    private String email;
    private String telephone;
    private BillingSerie billingSerie;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public BillingSerie getBillingSerie() {
        return billingSerie;
    }

    public void setBillingSerie(BillingSerie billingSerie) {
        this.billingSerie = billingSerie;
    }
}
