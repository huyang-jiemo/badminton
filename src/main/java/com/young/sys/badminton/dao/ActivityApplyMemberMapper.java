package com.young.sys.badminton.dao;

import com.young.sys.badminton.domain.ActivityApplyMember;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityApplyMemberMapper {

    List<ActivityApplyMember> selectByActivityId(Integer activityId);

    void insert(ActivityApplyMember activityMember);

    void deleteById(Integer id);

    void cancelApply(@Param("activityId")Integer activityId, @Param("userId")Integer userId);

    void deleteByClubId(Integer clubId);

    void deleteByActivityId(Integer activityId);
}