package com.young.sys.meetoo.dao;

import com.young.sys.meetoo.domain.MeetooMomentComment;

import java.util.List;

public interface MeetooMomentCommentMapper {

    List<MeetooMomentComment> selectCommentByMomentId(Integer momentId);

    Integer insert(MeetooMomentComment record);
}