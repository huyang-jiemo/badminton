package com.young.sys.badminton.domain;

public class Match {
    private Integer id;

    private Integer clubId;

    private String matchName;

    private String matchAddress;

    private Integer menSingle;

    private Integer womenSingle;

    private Integer menDouble;

    private Integer womenDouble;

    private Integer mixDouble;

    private Integer limitMember;

    private String matchMemo;

    private String startTime;

    private String endTime;

    private Integer status;

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

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public String getMatchAddress() {
        return matchAddress;
    }

    public void setMatchAddress(String matchAddress) {
        this.matchAddress = matchAddress;
    }

    public Integer getMenSingle() {
        return menSingle;
    }

    public void setMenSingle(Integer menSingle) {
        this.menSingle = menSingle;
    }

    public Integer getWomenSingle() {
        return womenSingle;
    }

    public void setWomenSingle(Integer womenSingle) {
        this.womenSingle = womenSingle;
    }

    public Integer getMenDouble() {
        return menDouble;
    }

    public void setMenDouble(Integer menDouble) {
        this.menDouble = menDouble;
    }

    public Integer getWomenDouble() {
        return womenDouble;
    }

    public void setWomenDouble(Integer womenDouble) {
        this.womenDouble = womenDouble;
    }

    public Integer getMixDouble() {
        return mixDouble;
    }

    public void setMixDouble(Integer mixDouble) {
        this.mixDouble = mixDouble;
    }

    public Integer getLimitMember() {
        return limitMember;
    }

    public void setLimitMember(Integer limitMember) {
        this.limitMember = limitMember;
    }

    public String getMatchMemo() {
        return matchMemo;
    }

    public void setMatchMemo(String matchMemo) {
        this.matchMemo = matchMemo;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}