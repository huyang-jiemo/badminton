package com.young.sys.badminton.model;

import com.young.sys.badminton.domain.Activity;
import com.young.sys.badminton.domain.ActivityMember;
import com.young.sys.badminton.domain.Club;
import com.young.sys.badminton.domain.User;

import java.util.List;

public class ActivityModel {

    private Activity activity;

    private Club club;

    private User user;

    private List<ActivityMember> activityMemberList;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

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

    public List<ActivityMember> getActivityMemberList() {
        return activityMemberList;
    }

    public void setActivityMemberList(List<ActivityMember> activityMemberList) {
        this.activityMemberList = activityMemberList;
    }
}
