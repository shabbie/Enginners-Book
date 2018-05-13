package com.gtu.EngBook.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "articles")
public class ArticlesModel implements Serializable {

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    UserModel userModel;


    @Column(name = "dept_id")
    private long deptId;

    @Id
    @Column(name = "article_id")
    private long articleId;

    @Column(name = "likes")
    private long likes;

    @Column(name = "article_type")
    private int articleType;

    @Column(name = "article_text")
    private String articleText;

    @Column(name = "article_image")
    private String articleImage;

    @Column(name = "create_time")
    private long createTime;

    @Column(name = "type")
    private boolean type;

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }


    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }


    public ArticlesModel() {
    }


    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public int getArticleType() {
        return articleType;
    }

    public void setArticleType(int articleType) {
        this.articleType = articleType;
    }

    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
    }

    public String getArticleImage() {
        return articleImage;
    }

    /**
     *
     * @param userModel
     * @param deptId
     * @param articleId
     * @param likes
     * @param articleType
     * @param articleText
     * @param articleImage
     * @param createTime
     * @param type
     */
    public ArticlesModel(UserModel userModel, long deptId, long articleId, long likes, int articleType, String articleText, String articleImage, long createTime, boolean type) {
        this.userModel = userModel;
        this.deptId = deptId;
        this.articleId = articleId;
        this.likes = likes;
        this.articleType = articleType;
        this.articleText = articleText;
        this.articleImage = articleImage;
        this.createTime = createTime;
        this.type = type;
    }

    public void setArticleImage(String articleImage) {
        this.articleImage = articleImage;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}
