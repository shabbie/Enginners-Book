package com.gtu.EngBook.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "college")
public class CollegeModel implements Serializable
{
    @Id
    @Column(name = "colg_id")
    private int colgId;

    @Column(name = "univ_id")
    private int univ_id;

    @Column(name = "colg_name")
    private String colg_name;

    @Column(name = "website")
    private String website;

    @Column(name = "tpo_no")
    private long tpo_no;

    @Column(name = "tpo_name")
    private String tpo_name;

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    UserModel userModel;


    /**
     *
     * @param colgId
     * @param univ_id
     * @param colg_name
     * @param website
     * @param tpo_no
     * @param tpo_name
     * @param userModel
     */
    public CollegeModel(int colgId, int univ_id, String colg_name, String website, long tpo_no, String tpo_name, UserModel userModel) {
        this.colgId = colgId;
        this.univ_id = univ_id;
        this.colg_name = colg_name;
        this.website = website;
        this.tpo_no = tpo_no;
        this.tpo_name = tpo_name;
        this.userModel = userModel;
    }


    public CollegeModel() {
    }

    public long getColgId() {
        return colgId;
    }

    public void setColgId(int colgId) {
        this.colgId = colgId;
    }



    public long getUniv_id() {
        return univ_id;
    }

    public void setUniv_id(int univ_id) {
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
