package com.gtu.EngBook.model.TempModels;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class UserInfoModel implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private long userId;

    @Column(name = "fname")
    private String fname;

    @Column(name = "lname")
    private String lname;

    @Column(name = "profile_pic")
    private String profilePic;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public UserInfoModel() {
    }

    public UserInfoModel(long userId, String fname, String lname, String profilePic) {
        this.userId = userId;
        this.fname = fname;
        this.lname = lname;
        this.profilePic = profilePic;
    }
}
