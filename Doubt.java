package com.example.abhishekkoranne.engineersbook.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Abhishek Koranne on 16-12-2017.
 */

public class Doubt implements Parcelable {

    private int doubtId;
    private String doubt = "";
    private String doubtImageUrl = "";
    private int upVote = 0;
    private int downVote = 0;
    private User user;
    ArrayList<Answer> answerList = new ArrayList<>();


    protected Doubt(Parcel in) {
        doubtId = in.readInt();
        doubt = in.readString();
        doubtImageUrl = in.readString();
        upVote = in.readInt();
        downVote = in.readInt();
        user = in.readParcelable(User.class.getClassLoader());
        answerList = in.createTypedArrayList(Answer.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(doubtId);
        dest.writeString(doubt);
        dest.writeString(doubtImageUrl);
        dest.writeInt(upVote);
        dest.writeInt(downVote);
        dest.writeParcelable(user, flags);
        dest.writeTypedList(answerList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Doubt> CREATOR = new Creator<Doubt>() {
        @Override
        public Doubt createFromParcel(Parcel in) {
            return new Doubt(in);
        }

        @Override
        public Doubt[] newArray(int size) {
            return new Doubt[size];
        }
    };

    public int getDoubtId() {
        return doubtId;
    }

    public void setDoubtId(int doubtId) {
        this.doubtId = doubtId;
    }

    public String getDoubt() {
        return doubt;
    }

    public void setDoubt(String doubt) {
        this.doubt = doubt;
    }

    public String getDoubtImageUrl() {
        return doubtImageUrl;
    }

    public void setDoubtImageUrl(String doubtImageUrl) {
        this.doubtImageUrl = doubtImageUrl;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(ArrayList<Answer> answerList) {
        this.answerList = answerList;
    }
}