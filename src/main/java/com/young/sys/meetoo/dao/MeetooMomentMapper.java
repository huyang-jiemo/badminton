package com.young.sys.meetoo.dao;

import com.young.sys.meetoo.domain.MeetooMoment;
import com.young.sys.meetoo.domain.PageQuery;

import java.util.List;

public interface MeetooMomentMapper {

    MeetooMoment selectById(Integer id);

    Integer insert(MeetooMoment record);

    void update(MeetooMoment record);

    List<MeetooMoment> selectNewPageMoment(PageQuery query);

    List<MeetooMoment> selectHotPageMoment(PageQuery query);

    List<MeetooMoment> selectUserMoments(Integer userId);
}