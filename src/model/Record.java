package model;

import java.sql.Timestamp;

public class Record {

    private String uid;
    private String lid;
    private Timestamp startTime;
    private Timestamp endTime;
    private Timestamp scheduleTime;

    public Record() {
        this.uid = "";
        this.lid = "";
        this.startTime = null;
        this.endTime = null;
        this.scheduleTime = null;
    }

    public Record(String uid, String lid, Timestamp startTime) {
        this.uid = uid;
        this.lid = lid;
        this.startTime = startTime;
        this.endTime = null;
        this.scheduleTime = null;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Timestamp getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(Timestamp scheduleTime) {
        this.scheduleTime = scheduleTime;
    }
}
