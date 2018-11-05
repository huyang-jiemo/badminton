package com.young.sys.badminton.dao;

import com.young.sys.badminton.domain.MatchMember;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MatchMemberMapper {

    List<MatchMember> selectByMatchId(Integer matchId);

    List<MatchMember> selectByMatchIdAndMatchType(@Param("matchId") Integer matchId,@Param("matchType") Integer matchType);

    List<MatchMember> selectAll();

    MatchMember selectById(Integer id);

    void insert(MatchMember matchMember);

    void update(MatchMember matchMember);

    void deleteById(Integer id);
}