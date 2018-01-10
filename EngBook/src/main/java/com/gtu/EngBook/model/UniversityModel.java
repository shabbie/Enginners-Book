package com.gtu.EngBook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class UniversityModel implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private long user_id;

    @Column(name = "univ_name")
    private String univ_name;

    @Column(name = "univ_id")
    private int univ_id;

    @Column(name = "website")
    private String website;

    public UniversityModel(long user_id, String univ_name, int univ_id, String website) {
        this.user_id = user_id;
        this.univ_name = univ_name;
        this.univ_id = univ_id;
        this.website = website;
    }

    public UniversityModel() {
    }


    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUniv_name() {
        return univ_name;
    }

    public void setUniv_name(String univ_name) {
        this.univ_name = univ_name;
    }

    public int getUniv_id() {
        return univ_id;
    }

    public void setUniv_id(int univ_id) {
        this.univ_id = univ_id;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}