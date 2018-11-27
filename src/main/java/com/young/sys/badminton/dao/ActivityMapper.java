package com.young.sys.badminton.dao;

import com.young.sys.badminton.domain.Activity;

import java.util.List;

public interface ActivityMapper {

    List<Activity> selectAll();

    List<Activity> selectAllPast();
    
    List<Activity> selectAllFuture();
    
    List<Activity> selectByClubId(Integer clubId);

    List<Activity> selectByDate(String date);

    Activity selectById(Integer id);

    void insert(Activity activity);

    void update(Activity activity);

    void deleteById(Integer id);

    List<Activity> selectThisWeekByClub(Integer clubId);
}