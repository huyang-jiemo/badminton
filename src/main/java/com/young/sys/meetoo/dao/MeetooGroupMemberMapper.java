package com.young.sys.meetoo.dao;

import com.young.sys.meetoo.domain.MeetooGroupMember;

import java.util.List;

public interface MeetooGroupMemberMapper {

    List<MeetooGroupMember> selectByGroupId(Integer groupId);

    Integer insert(MeetooGroupMember record);

    void deleteById(Integer id);

    void deleteByGroupId(Integer groupId);
}