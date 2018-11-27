package com.young.sys.badminton.model;

import com.young.sys.badminton.domain.Activity;
import com.young.sys.badminton.domain.Club;
import com.young.sys.badminton.domain.User;

import java.util.List;

public class ClubApiModel {

    private Club club;

    private User user;

    List<Activity> activityList;

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

    public List<Activity> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }
}
