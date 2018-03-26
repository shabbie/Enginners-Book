package com.gtu.EngBook.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "comments")
public class CommentModel implements Serializable {

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    UserModel userModel;

    @Id
    @Column(name="comment_id")
    private long commentId;

    @Column(name = "article_id")
    private long articleId;

    @Column(name = "text")
    private String text;

    @Column(name = "create_time")
    private long createTime;

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public CommentModel() {
    }

    /**
     *
     * @param userModel
     * @param commentId
     * @param articleId
     * @param text
     * @param createTime
     */
    public CommentModel(UserModel userModel, long commentId, long articleId, String text, long createTime) {
        this.userModel = userModel;
        this.commentId = commentId;
        this.articleId = articleId;
        this.text = text;
        this.createTime = createTime;
    }
}
