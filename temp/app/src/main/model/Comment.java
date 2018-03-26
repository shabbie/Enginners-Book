package com.example.jiggy.askbindaas.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jiggy on 24-12-2017.
 */

public class Comment implements Parcelable {
    private long time;
    private int commentid;
    private String comment = "";
    private String commentImageUrl = "";
    private User user;

    public Comment(long time, int commentid, String comment, String commentImageUrl, User user) {
        this.time = time;
        this.commentid = commentid;
        this.comment = comment;
        this.commentImageUrl = commentImageUrl;
        this.user = user;
    }

    protected Comment(Parcel in) {
        time = in.readLong();
        commentid = in.readInt();
        comment = in.readString();
        commentImageUrl = in.readString();
        user = in.readParcelable(User.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(time);
        dest.writeInt(commentid);
        dest.writeString(comment);
        dest.writeString(commentImageUrl);
        dest.writeParcelable(user, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Comment> CREATOR = new Creator<Comment>() {
        @Override
        public Comment createFromParcel(Parcel in) {
            return new Comment(in);
        }

        @Override
        public Comment[] newArray(int size) {
            return new Comment[size];
        }
    };

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentImageUrl() {
        return commentImageUrl;
    }

    public void setCommentImageUrl(String commentImageUrl) {
        this.commentImageUrl = commentImageUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
