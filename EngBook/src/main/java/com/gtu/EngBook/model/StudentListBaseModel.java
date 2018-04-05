package com.gtu.EngBook.model;

public class StudentListBaseModel  {


    private String colg_name;
    private int year_of_passing;
    private int count;

    public String getColg_name() {
        return colg_name;
    }

    public void setColg_name(String colg_name) {
        this.colg_name = colg_name;
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


    public StudentListBaseModel(String colg_name, int year_of_passing, int count) {

        this.colg_name = colg_name;
        this.year_of_passing = year_of_passing;
        this.count = count;
    }
}
