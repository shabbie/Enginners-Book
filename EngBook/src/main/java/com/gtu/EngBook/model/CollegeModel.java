package com.gtu.EngBook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class CollegeModel implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name = "colg_id")
    private int colg_id;

    @Column(name = "user_id")
    private long user_id;

    @Column(name = "univ_id")
    private long univ_id;

    @Column(name = "colg_name")
    private String colg_name;

    @Column(name = "website")
    private String website;

    @Column(name = "tpo_no")
    private long tpo_no;

    @Column(name = "tpo_name")
    private String tpo_name;

    public CollegeModel(int colg_id, long user_id, long univ_id, String colg_name, String website, long tpo_no, String tpo_name) {
        this.colg_id = colg_id;
        this.user_id = user_id;
        this.univ_id = univ_id;
        this.colg_name = colg_name;
        this.website = website;
        this.tpo_no = tpo_no;
        this.tpo_name = tpo_name;
    }

    public CollegeModel() {
    }

    public long getColg_id() {
        return colg_id;
    }

    public void setColg_id(int colg_id) {
        this.colg_id = colg_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getUniv_id() {
        return univ_id;
    }

    public void setUniv_id(long univ_id) {
        this.univ_id = univ_id;
    }

    public String getColg_name() {
        return colg_name;
    }

    public void setColg_name(String colg_name) {
        this.colg_name = colg_name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public long getTpo_no() {
        return tpo_no;
    }

    public void setTpo_no(long tpo_no) {
        this.tpo_no = tpo_no;
    }

    public String getTpo_name() {
        return tpo_name;
    }

    public void setTpo_name(String tpo_name) {
        this.tpo_name = tpo_name;
    }
}
