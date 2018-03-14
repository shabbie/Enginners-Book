package com.gtu.EngBook.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "faculty")
public class FacultyModel implements Serializable
{
    @Id
    @Column(name = "enroll_no")
    private long enrollNo;

    @Column(name = "dept_id")
    private int dept_id;

    @Column(name = "colg_id")
    private int colg_id;

    @Column(name = "univ_id")
    private int univId;

    @Column(name = "ranking")
    private int rank;

    public int getUnivId() {
        return univId;
    }

    public void setUnivId(int univId) {
        this.univId = univId;
    }


    public FacultyModel(long user_id, long enroll_no, int dept_id, int colg_id, int univId, int rank, UserModel userModel) {
        this.enrollNo = enroll_no;
        this.dept_id = dept_id;
        this.colg_id = colg_id;
        this.univId = univId;
        this.rank = rank;
        this.userModel = userModel;
    }

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

    public FacultyModel() {
    }


    public long getEnroll_no() {
        return enrollNo;
    }

    public void setEnroll_no(long enroll_no) {
        this.enrollNo = enroll_no;
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
