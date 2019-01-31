package com.young.sys.meetoo.dao;

import com.young.sys.meetoo.domain.MeetooUser;
import com.young.sys.meetoo.domain.MeetooUserRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MeetooUserRelationMapper {

    MeetooUserRelation selectIsFan(@Param("fanUserId")Integer fanUserId, @Param("followUserId")Integer followUserId);

    Integer insert(MeetooUserRelation record);

    void deleteRelation(@Param("fanUserId")Integer fanUserId, @Param("followUserId")Integer followUserId);

    List<MeetooUser> selectUserFollows(Integer userId);

    List<MeetooUser> selectUserFans(Integer userId);
}