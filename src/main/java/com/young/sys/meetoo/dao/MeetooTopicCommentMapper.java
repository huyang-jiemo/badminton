package com.young.sys.meetoo.dao;

import com.young.sys.meetoo.domain.MeetooTopicComment;

import java.util.List;

public interface MeetooTopicCommentMapper {

    List<MeetooTopicComment> selectByTopicId(Integer topicId);

    Integer insert(MeetooTopicComment record);

    void deleteById(Integer id);

    void deleteByTopicId(Integer topicId);
}