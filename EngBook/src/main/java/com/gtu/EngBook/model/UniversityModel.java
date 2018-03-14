package com.gtu.EngBook.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "university")
public class UniversityModel implements Serializable
{

    @Column(name = "uni_name")
    private String univ_name;

    @Id
    @Column(name = "uni_id")
    private int univ_id;

    @Column(name = "website")
    private String website;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    UserModel userModel;

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }


    /**
     *
     * @param univ_name
     * @param univ_id
     * @param website
     * @param userModel
     */
    public UniversityModel(String univ_name, int univ_id, String website, UserModel userModel) {
        this.univ_name = univ_name;
        this.univ_id = univ_id;
        this.website = website;
        this.userModel = userModel;
    }


    public UniversityModel() {
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