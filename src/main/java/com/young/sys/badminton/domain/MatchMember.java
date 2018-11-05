package com.young.sys.badminton.domain;

public class MatchMember {
    private Integer id;

    private Integer matchId;

    private Integer matchType;

    private String matchJudge;

    private String againstMember;

    private Integer againstSort;

    private String winner;

    private String matchPoint1;

    private String matchPoint2;

    private String matchPoint3;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Integer getMatchType() {
        return matchType;
    }

    public void setMatchType(Integer matchType) {
        this.matchType = matchType;
    }

    public String getMatchJudge() {
        return matchJudge;
    }

    public void setMatchJudge(String matchJudge) {
        this.matchJudge = matchJudge;
    }

    public String getAgainstMember() {
        return againstMember;
    }

    public void setAgainstMember(String againstMember) {
        this.againstMember = againstMember;
    }

    public Integer getAgainstSort() {
        return againstSort;
    }

    public void setAgainstSort(Integer againstSort) {
        this.againstSort = againstSort;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getMatchPoint1() {
        return matchPoint1;
    }

    public void setMatchPoint1(String matchPoint1) {
        this.matchPoint1 = matchPoint1;
    }

    public String getMatchPoint2() {
        return matchPoint2;
    }

    public void setMatchPoint2(String matchPoint2) {
        this.matchPoint2 = matchPoint2;
    }

    public String getMatchPoint3() {
        return matchPoint3;
    }

    public void setMatchPoint3(String matchPoint3) {
        this.matchPoint3 = matchPoint3;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}