package com.gtu.EngBook.model.TempModels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "doubts")
public class DoubtsAnswersModel implements Serializable {
    @Id
    @Column(name = "doubt_id")
    private long doubtId;

    @Column(name = "c")
    private int noOfAnswer;

    public DoubtsAnswersModel() {
    }

    public DoubtsAnswersModel(long doubtId, int noOfAnswer) {
        this.doubtId = doubtId;
        this.noOfAnswer = noOfAnswer;
    }

    public long getDoubtId() {
        return doubtId;
    }

    public void setDoubtId(long doubtId) {
        this.doubtId = doubtId;
    }

    public int getNoOfAnswer() {
        return noOfAnswer;
    }

    public void setNoOfAnswer(int noOfAnswer) {
        this.noOfAnswer = noOfAnswer;
    }
}
