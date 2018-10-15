package com.young.sys.badminton.domain;

public class ActivityMember {
    private Integer id;

    private Integer activityId;

    private String nick;

    private Integer memberNum;

    private Integer memberSex;

    private Long memberPhone;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(Integer memberNum) {
        this.memberNum = memberNum;
    }

    public Integer getMemberSex() {
        return memberSex;
    }

    public void setMemberSex(Integer memberSex) {
        this.memberSex = memberSex;
    }

    public Long getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(Long memberPhone) {
        this.memberPhone = memberPhone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}