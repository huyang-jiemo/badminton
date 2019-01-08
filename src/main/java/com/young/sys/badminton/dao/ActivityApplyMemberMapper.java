package com.young.sys.badminton.dao;

import com.young.sys.badminton.domain.ActivityApplyMember;

import java.util.List;

public interface ActivityApplyMemberMapper {

    List<ActivityApplyMember> selectByActivityId(Integer activityId);

    void insert(ActivityApplyMember activityMember);

    void deleteById(Integer id);
}