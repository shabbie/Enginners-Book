package com.gtu.EngBook.model.TempModels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "articles")
public class ArticlesCommentsModel implements Serializable {
    @Id
    @Column(name = "article_id")
    private long articleId;

    @Column(name = "c")
    private int noOfComments;

    public ArticlesCommentsModel(long articleId, int noOfComments) {
        this.articleId = articleId;
        this.noOfComments = noOfComments;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public int getNoOfComments() {
        return noOfComments;
    }

    public void setNoOfComments(int noOfComments) {
        this.noOfComments = noOfComments;
    }

    public ArticlesCommentsModel() {
    }
}

