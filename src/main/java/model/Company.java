package model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by eloylp on 4/12/16.
 */
@Document
public class Company {

    @Id
    private String id;
    private String name;
    private String identity;
    private String address;
    private String email;
    private String telephone;
    private CompanyConfiguration configuration;
    private int sequential;

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

    public int getSequential() {
        return sequential;
    }

    public void setSequential(int sequential) {
        this.sequential = sequential;
    }

    public CompanyConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(CompanyConfiguration configuration) {
        this.configuration = configuration;
    }
}
