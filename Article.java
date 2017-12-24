package com.example.abhishekkoranne.engineersbook.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Abhishek Koranne on 20-12-2017.
 */

public class Article implements Parcelable {

    private long time;
    private int articleid;
    private String article = "";
    private String articleImageUrl = "";
    private int likes;
    private int comments;
    private int shares;
    private User user;
    ArrayList<Comment> commentList= new ArrayList<>();

    protected Article(Parcel in) {
        time = in.readLong();
        articleid = in.readInt();
        article = in.readString();
        articleImageUrl = in.readString();
        likes = in.readInt();
        comments = in.readInt();
        shares = in.readInt();
        user = in.readParcelable(User.class.getClassLoader());
        commentList = in.createTypedArrayList(Comment.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(time);
        dest.writeInt(articleid);
        dest.writeString(article);
        dest.writeString(articleImageUrl);
        dest.writeInt(likes);
        dest.writeInt(comments);
        dest.writeInt(shares);
        dest.writeParcelable(user, flags);
        dest.writeTypedList(commentList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getArticleid() {
        return articleid;
    }

    public void setArticleid(int articleid) {
        this.articleid = articleid;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getArticleImageUrl() {
        return articleImageUrl;
    }

    public void setArticleImageUrl(String articleImageUrl) {
        this.articleImageUrl = articleImageUrl;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static Creator<Article> getCREATOR() {
        return CREATOR;
    }


    public ArrayList<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(ArrayList<Comment> commentList) {
        this.commentList = commentList;
    }
}