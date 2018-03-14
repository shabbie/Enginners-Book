package com.gtu.EngBook.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "hod")
public class HodModel implements Serializable
{
    @Id
    @Column(name = "enroll_no")
    private long enroll_no;

    @Column(name = "dept_id")
    private int dept_id;

    @Column(name = "colg_id")
    private int colg_id;

    @Column(name = "univ_id")
    private int univId;

    public int getUnivId() {
        return univId;
    }

    public void setUnivId(int univId) {
        this.univId = univId;
    }

    @Column(name = "ranking")
    private int rank;


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


    public HodModel(long user_id, long enroll_no, int dept_id, int colg_id, int rank) {
        this.enroll_no = enroll_no;
        this.dept_id = dept_id;
        this.colg_id = colg_id;
        this.rank = rank;
    }

    public HodModel() {
    }


    public long getEnroll_no() {
        return enroll_no;
    }

    public void setEnroll_no(long enroll_no) {
        this.enroll_no = enroll_no;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public int getColg_id() {
        return colg_id;
    }

    public void setColg_id(int colg_id) {
        this.colg_id = colg_id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}