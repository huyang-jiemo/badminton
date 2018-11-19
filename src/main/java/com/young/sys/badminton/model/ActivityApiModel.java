package com.young.sys.badminton.model;

public class ActivityApiModel {

    private Integer id;

    private String startTime;

    private String endTime;

    private Integer limitMember;

    private String activityAddress;

    private String clubName;

    //1-未开始；2-进行中；3-已结束
    private int activityStatus;

    //已报人数
    private int applyMember;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getLimitMember() {
        return limitMember;
    }

    public void setLimitMember(Integer limitMember) {
        this.limitMember = limitMember;
    }

    public String getActivityAddress() {
        return activityAddress;
    }

    public void setActivityAddress(String activityAddress) {
        this.activityAddress = activityAddress;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public int getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(int activityStatus) {
        this.activityStatus = activityStatus;
    }

    public int getApplyMember() {
        return applyMember;
    }

    public void setApplyMember(int applyMember) {
        this.applyMember = applyMember;
    }
}
