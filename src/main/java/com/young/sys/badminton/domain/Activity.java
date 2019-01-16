package com.young.sys.badminton.domain;

import com.young.sys.badminton.util.DateUtil;

public class Activity {

    private Integer id;

    private Integer clubId;

    private String activityDate;

    private String startTime;

    private String endTime;

    private Integer limitMember;

    private String activityAddress;

    private String activityMemo;

    private Integer status;

    private String weekdayName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }

    public String getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(String activityDate) {
        this.activityDate = activityDate;
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

    public String getActivityMemo() {
        return activityMemo;
    }

    public void setActivityMemo(String activityMemo) {
        this.activityMemo = activityMemo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getWeekdayName() {
        return DateUtil.dayForWeek(activityDate);
    }

    public void setWeekdayName(String weekdayName) {
        this.weekdayName = weekdayName;
    }
}