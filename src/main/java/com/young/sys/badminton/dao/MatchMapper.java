package com.young.sys.badminton.dao;

import com.young.sys.badminton.domain.Match;

import java.util.List;

public interface MatchMapper {

    List<Match> selectAll();

    Match selectById(Integer id);

    void insert(Match match);

    void update(Match match);

    void deleteById(Integer id);
}