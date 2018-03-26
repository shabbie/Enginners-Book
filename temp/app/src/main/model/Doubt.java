package com.example.jiggy.askbindaas.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Jiggy on 24-12-2017.
 */

//alt-shift-ins for getter nd setter

public class Doubt implements Parcelable {
    private long time;
    private int doubtId;
    private String doubt = "";
    private String doubtImageUrl = "";
    private int upVote = 0;
    private int downVote = 0;
    private User user;
    ArrayList<Answer> answerList = new ArrayList<>();
    ArrayList<String> doubtTagsList = new ArrayList<>();


    protected Doubt(Parcel in) {
        time = in.readLong();
        doubtId = in.readInt();
        doubt = in.readString();
        doubtImageUrl = in.readString();
        upVote = in.readInt();
        downVote = in.readInt();
        user = in.readParcelable(User.class.getClassLoader());
        answerList = in.createTypedArrayList(Answer.CREATOR);
        doubtTagsList = in.createStringArrayList();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(time);
        dest.writeInt(doubtId);
        dest.writeString(doubt);
        dest.writeString(doubtImageUrl);
        dest.writeInt(upVote);
        dest.writeInt(downVote);
        dest.writeParcelable(user, flags);
        dest.writeTypedList(answerList);
        dest.writeStringList(doubtTagsList);
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

    public ArrayList<String> getDoubtTagsList() {
        return doubtTagsList;
    }

    public void setDoubtTagsList(ArrayList<String> doubtTagsList) {
        this.doubtTagsList = doubtTagsList;
    }

    public Doubt(long time, int doubtId, String doubt, String doubtImageUrl, int upVote, int downVote, User user, ArrayList<Answer> answerList, ArrayList<String> doubtTagsList) {
        this.time = time;
        this.doubtId = doubtId;
        this.doubt = doubt;
        this.doubtImageUrl = doubtImageUrl;
        this.upVote = upVote;
        this.downVote = downVote;
        this.user = user;
        this.answerList = answerList;
        this.doubtTagsList = doubtTagsList;
    }
}
