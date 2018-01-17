package com.gtu.EngBook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class AddressModel implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private long user_id;

    @Column(name = "street")
    private long street;

    @Column(name = "city")
    private long city;

    @Column(name = "pincode")
    private long pincode;

    @Column(name = "state")
    private long state;

    @Column(name = "country")
    private long country;

    public AddressModel(long user_id, long street, long city, long pincode, long state, long country) {
        this.user_id = user_id;
        this.street = street;
        this.city = city;
        this.pincode = pincode;
        this.state = state;
        this.country = country;
    }

    public AddressModel() {
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getStreet() {
        return street;
    }

    public void setStreet(long street) {
        this.street = street;
    }

    public long getCity() {
        return city;
    }

    public void setCity(long city) {
        this.city = city;
    }

    public long getPincode() {
        return pincode;
    }

    public void setPincode(long pincode) {
        this.pincode = pincode;
    }

    public long getState() {
        return state;
    }

    public void setState(long state) {
        this.state = state;
    }

    public long getCountry() {
        return country;
    }

    public void setCountry(long country) {
        this.country = country;
    }
}
