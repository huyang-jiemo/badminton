package com.young.sys.badminton.model;

import com.young.sys.badminton.domain.Club;
import com.young.sys.badminton.domain.ClubMember;
import com.young.sys.badminton.domain.User;

import java.util.List;

public class ClubModel {
    private User user;

    private Club club;

    private List<ClubMember> clubMemberList;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public List<ClubMember> getClubMemberList() {
        return clubMemberList;
    }

    public void setClubMemberList(List<ClubMember> clubMemberList) {
        this.clubMemberList = clubMemberList;
    }
}
