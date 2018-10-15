package com.young.sys.badminton.dao;

import com.young.sys.badminton.domain.ActivityMember;

import java.util.List;

public interface ActivityMemberMapper {

    List<ActivityMember> selectByActivityId(Integer activityId);

    void insert(ActivityMember activityMember);

    void deleteById(Integer id);
}