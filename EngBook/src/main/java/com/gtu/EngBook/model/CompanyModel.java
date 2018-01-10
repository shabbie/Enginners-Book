package com.gtu.EngBook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class CompanyModel implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name = "comp_name")
    private String comp_name;

    @Column(name = "address")
    private String address;

    @Column(name = "hr_name")
    private String hr_name;

    @Column(name = "domain")
    private String domain;

    public CompanyModel(String comp_name, String address, String hr_name, String domain) {
        this.comp_name = comp_name;
        this.address = address;
        this.hr_name = hr_name;
        this.domain = domain;
    }

    public CompanyModel() {
    }

    public String getComp_name() {
        return comp_name;
    }

    public void setComp_name(String comp_name) {
        this.comp_name = comp_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHr_name() {
        return hr_name;
    }

    public void setHr_name(String hr_name) {
        this.hr_name = hr_name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
