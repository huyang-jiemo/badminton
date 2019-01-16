package com.young.sys.badminton.dao;

import com.young.sys.badminton.domain.ClubMember;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClubMemberMapper {

    List<ClubMember> selectByClubId(Integer clubId);

    ClubMember selectById(Integer id);

    ClubMember selectByUserId(Integer userId);

    void insert(ClubMember clubMember);

    void update(ClubMember clubMember);

    void deleteById(Integer id);

    void removeMember(@Param("userId")Integer userId, @Param("clubId")Integer clubId);
}
