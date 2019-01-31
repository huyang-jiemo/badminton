package com.young.sys.meetoo.model;

import com.young.sys.meetoo.domain.*;

import java.util.List;

public class MeetooMomentModel {

    private MeetooUser meetooUser;

    private MeetooMoment meetooMoment;

    private List<MeetooMomentPic> meetooMomentPicList;

    private List<MeetooMomentMark> meetooMomentMarkList;

    private List<MeetooMomentComment> meetooMomentCommentList;

    public MeetooUser getMeetooUser() {
        return meetooUser;
    }

    public void setMeetooUser(MeetooUser meetooUser) {
        this.meetooUser = meetooUser;
    }

    public MeetooMoment getMeetooMoment() {
        return meetooMoment;
    }

    public void setMeetooMoment(MeetooMoment meetooMoment) {
        this.meetooMoment = meetooMoment;
    }

    public List<MeetooMomentPic> getMeetooMomentPicList() {
        return meetooMomentPicList;
    }

    public void setMeetooMomentPicList(List<MeetooMomentPic> meetooMomentPicList) {
        this.meetooMomentPicList = meetooMomentPicList;
    }

    public List<MeetooMomentMark> getMeetooMomentMarkList() {
        return meetooMomentMarkList;
    }

    public void setMeetooMomentMarkList(List<MeetooMomentMark> meetooMomentMarkList) {
        this.meetooMomentMarkList = meetooMomentMarkList;
    }

    public List<MeetooMomentComment> getMeetooMomentCommentList() {
        return meetooMomentCommentList;
    }

    public void setMeetooMomentCommentList(List<MeetooMomentComment> meetooMomentCommentList) {
        this.meetooMomentCommentList = meetooMomentCommentList;
    }
}
