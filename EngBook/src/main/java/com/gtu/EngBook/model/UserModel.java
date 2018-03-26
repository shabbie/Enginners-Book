package com.gtu.EngBook.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="user")
public class UserModel implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private long userId;

    @Column(name = "password")
    private String password;

    @Column(name = "login_status")
    private boolean loginStatus;

    @Column(name = "fname")
    private String fname;

    @Column(name = "lname")
    private String lname;

    @Column(name = "profile_pic")
    private String profilePic;


    @Column(name = "gender")
    private int gender;

    @Column(name = "dob")
    private String dob;

    @Column(name = "email")
    private String email;

    @Column(name = "contact")
    private long contact;

    @Column(name = "address")
    private String address;


    @Column(name = "user_type")
    private String userType;


    // Relationship
    @OneToOne(mappedBy = "userModel", cascade=CascadeType.ALL)
    @JsonManagedReference
    StudentModel studentModel;

    @OneToOne(mappedBy = "userModel", cascade=CascadeType.ALL)
    @JsonManagedReference
    FacultyModel facultyModel;

    @OneToOne(mappedBy = "userModel", cascade=CascadeType.ALL)
    @JsonManagedReference
    HodModel hodModel;


    @OneToOne(mappedBy = "userModel",cascade=CascadeType.ALL)
    @JsonManagedReference
    CollegeModel collegeModel;

    @OneToOne(mappedBy = "userModel", cascade=CascadeType.ALL)
    @JsonManagedReference
    UniversityModel universityModel;

    @OneToMany(mappedBy = "userModel", cascade=CascadeType.ALL)
    @JsonManagedReference
    List<ArticlesModel> articlesModel;

    @OneToMany(mappedBy = "userModel", cascade=CascadeType.ALL)
    @JsonManagedReference
    List<CommentModel> commentModel;

    @OneToMany(mappedBy = "userModel", cascade=CascadeType.ALL)
    @JsonManagedReference
    List<CommentModel> doubtModel;

    @OneToMany(mappedBy = "userModel", cascade=CascadeType.ALL)
    @JsonManagedReference
    List<AnswerModel> answerModel;


    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public List<AnswerModel> getAnswerModel() {
        return answerModel;
    }

    public void setAnswerModel(List<AnswerModel> answerModel) {
        this.answerModel = answerModel;
    }

    public HodModel getHodModel() {
        return hodModel;
    }

    public void setHodModel(HodModel hodModel) {
        this.hodModel = hodModel;
    }

    public CollegeModel getCollegeModel() {
        return collegeModel;
    }

    public void setCollegeModel(CollegeModel collegeModel) {
        this.collegeModel = collegeModel;
    }

    public List<CommentModel> getDoubtModel() {
        return doubtModel;
    }

    public void setDoubtModel(List<CommentModel> doubtModel) {
        this.doubtModel = doubtModel;
    }

    public UniversityModel getUniversityModel() {
        return universityModel;
    }

    public void setUniversityModel(UniversityModel universityModel) {
        this.universityModel = universityModel;
    }

    public List<ArticlesModel> getArticlesModel() {
        return articlesModel;
    }

    public void setArticlesModel(List<ArticlesModel> articlesModel) {
        this.articlesModel = articlesModel;
    }

    public StudentModel getStudentModel() {
        return studentModel;
    }

    public void setStudentModel(StudentModel studentModel) {
        this.studentModel = studentModel;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoginstatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }


    public FacultyModel getFacultyModel() {
        return facultyModel;
    }

    public void setFacultyModel(FacultyModel facultyModel) {
        this.facultyModel = facultyModel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    //** constructors **//
    public UserModel() {
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public List<CommentModel> getCommentModel() {
        return commentModel;
    }

    public void setCommentModel(List<CommentModel> commentModel) {
        this.commentModel = commentModel;
    }

    /**
     *
     * @param userId
     * @param password
     * @param loginStatus
     * @param fname
     * @param lname
     * @param profilePic
     * @param gender
     * @param dob
     * @param email
     * @param contact
     * @param address
     * @param userType
     * @param studentModel
     * @param facultyModel
     * @param hodModel
     * @param collegeModel
     * @param universityModel
     * @param articlesModel
     * @param commentModel
     * @param doubtModel
     * @param answerModel
     */
    public UserModel(long userId, String password, boolean loginStatus, String fname, String lname, String profilePic, int gender, String dob, String email, long contact, String address, String userType, StudentModel studentModel, FacultyModel facultyModel, HodModel hodModel, CollegeModel collegeModel, UniversityModel universityModel, List<ArticlesModel> articlesModel, List<CommentModel> commentModel, List<CommentModel> doubtModel, List<AnswerModel> answerModel) {
        this.userId = userId;
        this.password = password;
        this.loginStatus = loginStatus;
        this.fname = fname;
        this.lname = lname;
        this.profilePic = profilePic;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.userType = userType;
        this.studentModel = studentModel;
        this.facultyModel = facultyModel;
        this.hodModel = hodModel;
        this.collegeModel = collegeModel;
        this.universityModel = universityModel;
        this.articlesModel = articlesModel;
        this.commentModel = commentModel;
        this.doubtModel = doubtModel;
        this.answerModel = answerModel;
    }
}