package com.gtu.EngBook.model.TempModels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "student")
public class StudentListBaseModel implements Serializable {


    @Id
    @Column(name = "enroll_no")
    private long enrollNo;
    @Column(name = "colg_id")
    private String colg_id;
    @Column(name = "year_of_passing")
    private int year_of_passing;
    @Column(name = "c")
    private int count;

    public long getEnrollNo() {
        return enrollNo;
    }

    public void setEnrollNo(long enrollNo) {
        this.enrollNo = enrollNo;
    }

    public String getColg_id() {
        return colg_id;
    }

    public void setColg_id(String colg_id) {
        this.colg_id = colg_id;
    }

    public int getYear_of_passing() {
        return year_of_passing;
    }

    public void setYear_of_passing(int year_of_passing) {
        this.year_of_passing = year_of_passing;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public StudentListBaseModel() {
    }


    /**
     *
     * @param enrollNo
     * @param colg_id
     * @param year_of_passing
     * @param count
     */
    public StudentListBaseModel(long enrollNo, String colg_id, int year_of_passing, int count) {
        this.enrollNo = enrollNo;
        this.colg_id = colg_id;
        this.year_of_passing = year_of_passing;
        this.count = count;
    }
}
