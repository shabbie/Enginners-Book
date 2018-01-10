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
    private long dept_id;

    @Column(name = "dept_name")
    private int dept_name;

    @Column(name = "dept_name")
    private int hod_name;

    @Column(name = "no_of_placements")
    private int no_of_placements;

    @Column(name = "colg_id")
    private int colg_id;

    public long getDept_id() {
        return dept_id;
    }

    public void setDept_id(long dept_id) {
        this.dept_id = dept_id;
    }

    public int getDept_name() {
        return dept_name;
    }

    public void setDept_name(int dept_name) {
        this.dept_name = dept_name;
    }

    public int getHod_name() {
        return hod_name;
    }

    public void setHod_name(int hod_name) {
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
