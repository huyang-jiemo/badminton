package com.young.sys.meetoo.dao;

import com.young.sys.meetoo.domain.MeetooTopic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MeetooTopicMapper {

    MeetooTopic selectById(Integer id);

    List<MeetooTopic> selectByGroupId(Integer groupId);

    Integer insert(MeetooTopic record);

    void updateTopicPicture(MeetooTopic record);

    void deleteById(Integer id);

    void deleteByGroupId(Integer groupId);

    List<MeetooTopic> selectGroupMyTopic(@Param("groupId") Integer groupId, @Param("userId") Integer userId);
}