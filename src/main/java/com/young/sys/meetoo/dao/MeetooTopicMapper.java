package com.young.sys.meetoo.dao;

import com.young.sys.meetoo.domain.MeetooTopic;

import java.util.List;

public interface MeetooTopicMapper {

    MeetooTopic selectById(Integer id);

    List<MeetooTopic> selectByGroupId(Integer groupId);

    Integer insert(MeetooTopic record);

    void updateTopicPicture(MeetooTopic record);

    void deleteById(Integer id);

    void deleteByGroupId(Integer groupId);
}