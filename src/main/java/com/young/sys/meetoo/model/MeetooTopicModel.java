package com.young.sys.meetoo.model;

import com.young.sys.meetoo.domain.MeetooTopic;
import com.young.sys.meetoo.domain.MeetooTopicComment;
import com.young.sys.meetoo.domain.MeetooUser;

import java.util.List;

public class MeetooTopicModel {
    private MeetooTopic meetooTopic;

    private MeetooUser meetooUser;

    List<String> meetooTopicPicList;

    List<MeetooTopicComment> meetooTopicCommentList;

    public MeetooTopic getMeetooTopic() {
        return meetooTopic;
    }

    public void setMeetooTopic(MeetooTopic meetooTopic) {
        this.meetooTopic = meetooTopic;
    }

    public MeetooUser getMeetooUser() {
        return meetooUser;
    }

    public void setMeetooUser(MeetooUser meetooUser) {
        this.meetooUser = meetooUser;
    }

    public List<String> getMeetooTopicPicList() {
        return meetooTopicPicList;
    }

    public void setMeetooTopicPicList(List<String> meetooTopicPicList) {
        this.meetooTopicPicList = meetooTopicPicList;
    }

    public List<MeetooTopicComment> getMeetooTopicCommentList() {
        return meetooTopicCommentList;
    }

    public void setMeetooTopicCommentList(List<MeetooTopicComment> meetooTopicCommentList) {
        this.meetooTopicCommentList = meetooTopicCommentList;
    }
}
