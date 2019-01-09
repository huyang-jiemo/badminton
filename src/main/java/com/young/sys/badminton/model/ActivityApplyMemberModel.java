package com.young.sys.badminton.model;

import com.young.sys.badminton.domain.Activity;
import com.young.sys.badminton.domain.ActivityApplyMember;
import com.young.sys.badminton.domain.User;

public class ActivityApplyMemberModel {
    private Activity activity;
    private ActivityApplyMember activityApplyMember;
    private User user;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public ActivityApplyMember getActivityApplyMember() {
        return activityApplyMember;
    }

    public void setActivityApplyMember(ActivityApplyMember activityApplyMember) {
        this.activityApplyMember = activityApplyMember;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
