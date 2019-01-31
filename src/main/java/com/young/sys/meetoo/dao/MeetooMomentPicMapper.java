package com.young.sys.meetoo.dao;

import com.young.sys.meetoo.domain.MeetooMomentPic;

import java.util.List;

public interface MeetooMomentPicMapper {

    List<MeetooMomentPic> selectPicByMomentId(Integer momentId);

    Integer insert(MeetooMomentPic record);
}