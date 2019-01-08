package com.young.sys.badminton.model;

import com.young.sys.badminton.domain.Activity;
import com.young.sys.badminton.domain.ActivityApplyMember;
import com.young.sys.badminton.domain.Club;
import com.young.sys.badminton.domain.User;

import java.util.List;

public class ActivityDetailModel {
    private Club club;
    private User user;
    private Activity activity;
    private List<ActivityApplyMember> activityApplyMemberList;
    private Integer activityStatus;

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public List<ActivityApplyMember> getActivityApplyMemberList() {
        return activityApplyMemberList;
    }

    public void setActivityApplyMemberList(List<ActivityApplyMember> activityApplyMemberList) {
        this.activityApplyMemberList = activityApplyMemberList;
    }

    public Integer getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(Integer activityStatus) {
        this.activityStatus = activityStatus;
    }
}

