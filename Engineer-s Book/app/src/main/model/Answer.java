package com.example.abhishekkoranne.engineersbook.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Abhishek Koranne on 24-12-2017.
 */

public class Answer implements Parcelable {
    private long time;
    private int doubtId;
    private int commentId;
    private String comment = "";
    private int upVote = 0;
    private int downVote = 0;
    private String answer = "";
    private User user;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getDoubtId() {
        return doubtId;
    }

    public void setDoubtId(int doubtId) {
        this.doubtId = doubtId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getUpVote() {
        return upVote;
    }

    public void setUpVote(int upVote) {
        this.upVote = upVote;
    }

    public int getDownVote() {
        return downVote;
    }

    public void setDownVote(int downVote) {
        this.downVote = downVote;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Answer(long time, int doubtId, int commentId, String comment, int upVote, int downVote, String answer, User user) {
        this.time = time;
        this.doubtId = doubtId;
        this.commentId = commentId;
        this.comment = comment;
        this.upVote = upVote;
        this.downVote = downVote;
        this.answer = answer;
        this.user = user;
    }

    protected Answer(Parcel in) {
        time = in.readLong();
        doubtId = in.readInt();
        commentId = in.readInt();
        comment = in.readString();
        upVote = in.readInt();
        downVote = in.readInt();
        answer = in.readString();
        user = in.readParcelable(User.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(time);
        dest.writeInt(doubtId);
        dest.writeInt(commentId);
        dest.writeString(comment);
        dest.writeInt(upVote);
        dest.writeInt(downVote);
        dest.writeString(answer);
        dest.writeParcelable(user, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Answer> CREATOR = new Creator<Answer>() {
        @Override
        public Answer createFromParcel(Parcel in) {
            return new Answer(in);
        }

        @Override
        public Answer[] newArray(int size) {
            return new Answer[size];
        }
    };
}
