package com.young.sys.meetoo.dao;

import com.young.sys.meetoo.domain.MeetooMomentMark;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MeetooMomentMarkMapper {

    MeetooMomentMark selectMarkByMomentIdAndUserId(@Param("momentId")Integer momentId, @Param("userId")Integer userId);

    List<MeetooMomentMark> selectMarkByMomentId(Integer momentId);

    Integer insert(MeetooMomentMark record);
}