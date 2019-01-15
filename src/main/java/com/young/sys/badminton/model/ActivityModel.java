package com.young.sys.badminton.model;

import com.young.sys.badminton.domain.Activity;
import com.young.sys.badminton.domain.ActivityApplyMember;
import com.young.sys.badminton.domain.Club;

import java.util.List;

public class ActivityModel {
    private Club club;
    private Activity activity;
    private Integer activityStatus;
    private List<ActivityApplyMember> activityApplyMemberList;

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

    public List<ActivityApplyMember> getActivityApplyMemberList() {
        return activityApplyMemberList;
    }

    public void setActivityApplyMemberList(List<ActivityApplyMember> activityApplyMemberList) {
        this.activityApplyMemberList = activityApplyMemberList;
    }
}
