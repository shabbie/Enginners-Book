package com.gtu.EngBook.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "answers")
public class AnswerModel implements Serializable {

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    UserModel userModel;

    @Id
    @Column(name="answer_id")
    private long answerId;

    @Column(name = "doubt_id")
    private long doubtId;

    @Column(name = "text")
    private String text;

    @Column(name = "answer_image")
    private String answerImage;

    @Column(name ="downvotes")
    private int downvote;

    @Column(name = "upvotes")
    private int upvote;

    @Column(name = "create_time")
    private long createTime;

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
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

    public String getAnswerImage() {
        return answerImage;
    }

    public void setAnswerImage(String answerImage) {
        this.answerImage = answerImage;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getDownvote() {
        return downvote;
    }

    public void setDownvote(int downvote) {
        this.downvote = downvote;
    }

    public int getUpvote() {
        return upvote;
    }

    public void setUpvote(int upvote) {
        this.upvote = upvote;
    }

    /**
     *  @param userModel
     * @param answerId
     * @param doubtId
     * @param text
     * @param answerImage
     * @param downvote
     * @param upvote
     * @param createTime
     */

    public AnswerModel(UserModel userModel, long answerId, long doubtId, String text, String answerImage, int downvote, int upvote, long createTime) {
        this.userModel = userModel;
        this.answerId = answerId;
        this.doubtId = doubtId;
        this.text = text;
        this.answerImage = answerImage;
        this.downvote = downvote;
        this.upvote = upvote;
        this.createTime = createTime;
    }


    public AnswerModel() {
    }
}
