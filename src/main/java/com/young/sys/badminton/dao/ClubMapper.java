package com.young.sys.badminton.dao;

import com.young.sys.badminton.domain.Club;

import java.util.List;

public interface ClubMapper {

    List<Club> selectAll();

    Club selectById(Integer id);

    Club selectByUserId(Integer userId);

    Integer insert(Club club);

    void update(Club club);

    void deleteById(Integer id);
}