package com.young.sys.badminton.dao;

import com.young.sys.badminton.domain.MatchEnter;

import java.util.List;

public interface MatchEnterMapper {

    List<MatchEnter> selectByMatchId(Integer matchId);

    void insert(MatchEnter record);

    void deleteById(Integer id);
}