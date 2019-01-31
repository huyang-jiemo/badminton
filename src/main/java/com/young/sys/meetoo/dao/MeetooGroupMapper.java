package com.young.sys.meetoo.dao;

import com.young.sys.meetoo.domain.MeetooGroup;

import java.util.List;

public interface MeetooGroupMapper {

    MeetooGroup selectById(Integer id);

    List<MeetooGroup> selectByType(Integer type);

    List<MeetooGroup> selectUserGroups(Integer userId);

    List<MeetooGroup> selectMineGroups(Integer userId);

    Integer insert(MeetooGroup record);

    void update(MeetooGroup record);

    void deleteById(Integer id);
}