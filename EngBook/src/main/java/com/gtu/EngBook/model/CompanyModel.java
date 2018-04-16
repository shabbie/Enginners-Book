package com.gtu.EngBook.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "company")
public class CompanyModel implements Serializable
{
    @Id
    @Column(name = "comp_name")
    private String compName;

    @Column(name="comp_id")
    private long compId;

    @Column(name = "contact")
    private long contact;

    @Column(name = "hr_contact")
    private long hrContact;

    @Column(name = "address")
    private String address;

    @Column(name = "hr_name")
    private String hr_name;

    @Column(name = "domain")
    private String domain;

    @Column(name = "profile_pic")
    private String profilePic;

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    /**
     *  @param compName
     * @param compId
     * @param contact
     * @param hrContact
     * @param address
     * @param hr_name
     * @param domain
     * @param profilePic
     */
    public CompanyModel(String compName, long compId, long contact, long hrContact, String address, String hr_name, String domain, String profilePic) {
        this.compName = compName;
        this.compId = compId;
        this.contact = contact;
        this.hrContact = hrContact;
        this.address = address;
        this.hr_name = hr_name;
        this.domain = domain;
        this.profilePic = profilePic;
    }

    public CompanyModel() {
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public long getCompId() {
        return compId;
    }

    public void setCompId(long compId) {
        this.compId = compId;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public long getHrContact() {
        return hrContact;
    }

    public void setHrContact(long hrContact) {
        this.hrContact = hrContact;
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
