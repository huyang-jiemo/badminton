package com.young.sys.badminton.dao;

import com.young.sys.badminton.domain.ClubMember;

import java.util.List;

public interface ClubMemberMapper {

    List<ClubMember> selectByClubId(Integer clubId);

    void insert(ClubMember clubMember);

    void update(ClubMember clubMember);

    void deleteById(Integer id);
}
