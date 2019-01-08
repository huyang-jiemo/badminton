package com.young.sys.badminton.dao;

import com.young.sys.badminton.domain.Activity;

import java.util.List;

public interface ActivityMapper {

    List<Activity> selectAll();

    List<Activity> selectByClubId(Integer clubId);

    Activity selectById(Integer id);

    void insert(Activity activity);

    void update(Activity activity);

    void deleteById(Integer id);

    List<Activity> selectAllThisWeek();

    List<Activity> selectPast();

    List<Activity> selectMinePastActivity(Integer userId);
}