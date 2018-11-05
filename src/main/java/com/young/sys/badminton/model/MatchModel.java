package com.young.sys.badminton.model;

import com.young.sys.badminton.domain.Club;
import com.young.sys.badminton.domain.Match;
import com.young.sys.badminton.domain.MatchEnter;
import com.young.sys.badminton.domain.MatchMember;

import java.util.List;

public class MatchModel {

    private Match match;

    private Club club;

    private List<MatchEnter> matchEnterList;

    private List<MatchMember> matchMemberList;

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public List<MatchEnter> getMatchEnterList() {
        return matchEnterList;
    }

    public void setMatchEnterList(List<MatchEnter> matchEnterList) {
        this.matchEnterList = matchEnterList;
    }

    public List<MatchMember> getMatchMemberList() {
        return matchMemberList;
    }

    public void setMatchMemberList(List<MatchMember> matchMemberList) {
        this.matchMemberList = matchMemberList;
    }
}
