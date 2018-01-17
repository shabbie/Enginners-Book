package com.gtu.EngBook.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class DepartmentModel implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name = "dept_id")
    private int dept_id;

    @Column(name = "dept_name")
    private String dept_name;

    @Column(name = "hod_name")
    private String hod_name;

    @Column(name = "no_of_placements")
    private int no_of_placements;

    @Column(name = "colg_id")
    private int colg_id;

    public DepartmentModel(int dept_id, String dept_name, String hod_name, int no_of_placements, int colg_id) {
        this.dept_id = dept_id;
        this.dept_name = dept_name;
        this.hod_name = hod_name;
        this.no_of_placements = no_of_placements;
        this.colg_id = colg_id;
    }

    public DepartmentModel() {
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getHod_name() {
        return hod_name;
    }

    public void setHod_name(String hod_name) {
        this.hod_name = hod_name;
    }

    public int getNo_of_placements() {
        return no_of_placements;
    }

    public void setNo_of_placements(int no_of_placements) {
        this.no_of_placements = no_of_placements;
    }

    public int getColg_id() {
        return colg_id;
    }

    public void setColg_id(int colg_id) {
        this.colg_id = colg_id;
    }
}
