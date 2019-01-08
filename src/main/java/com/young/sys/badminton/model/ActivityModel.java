package com.young.sys.badminton.model;

import com.young.sys.badminton.domain.Activity;
import com.young.sys.badminton.domain.Club;

public class ActivityModel {
    private Club club;
    private Activity activity;
    private Integer activityStatus;

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Integer getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(Integer activityStatus) {
        this.activityStatus = activityStatus;
    }
}
