package com.gtu.EngBook.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "doubts")
public class DoubtModel implements Serializable {


    public void setDownvote(int downvote) {
        this.downvote = downvote;
    }

    public void setUpvote(int upvote) {
        this.upvote = upvote;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    UserModel userModel;

    @Id
    @Column(name="doubt_id")
    private long doubtId;

    @Column(name="dept_id")
    private long deptId;

    @Column(name ="downvotes")
    private int downvote;

    @Column(name = "create_time")
    private long createTime;

    @Column(name = "heading")
    private String heading;

    @Column(name = "text")
    private String text;

    @Column(name = "doubt_image")
    private String doubtImage;

    @Column(name = "tag")
    private String tag;

    @Column(name = "upvotes")
    private int upvote;



    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public long getDoubtId() {
        return doubtId;
    }

    public void setDoubtId(long doubtId) {
        this.doubtId = doubtId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDoubtImage() {
        return doubtImage;
    }

    public void setDoubtImage(String doubtImage) {
        this.doubtImage = doubtImage;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public long getUpvote() {
        return upvote;
    }

    public void setUpvote(long upvote) {
        this.upvote = (int) upvote;
    }

    public long getDownvote() {
        return downvote;
    }

    public void setDownvote(long downvote) {
        this.downvote = (int) downvote;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public DoubtModel() {
    }

    /**
     *
     * @param userModel
     * @param doubtId
     * @param deptId
     * @param downvote
     * @param createTime
     * @param heading
     * @param text
     * @param doubtImage
     * @param tag
     * @param upvote
     */
    public DoubtModel(UserModel userModel, long doubtId, long deptId, int downvote, long createTime, String heading, String text, String doubtImage, String tag, int upvote) {
        this.userModel = userModel;
        this.doubtId = doubtId;
        this.deptId = deptId;
        this.downvote = downvote;
        this.createTime = createTime;
        this.heading = heading;
        this.text = text;
        this.doubtImage = doubtImage;
        this.tag = tag;
        this.upvote = upvote;
    }
}
