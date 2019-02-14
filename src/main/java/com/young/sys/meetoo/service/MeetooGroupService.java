package com.young.sys.meetoo.service;

import com.vdurmont.emoji.EmojiParser;
import com.young.sys.meetoo.dao.MeetooGroupMapper;
import com.young.sys.meetoo.dao.MeetooGroupMemberMapper;
import com.young.sys.meetoo.domain.MeetooGroup;
import com.young.sys.meetoo.domain.MeetooGroupMember;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author huyang8
 * @date 2019-01-30 14:43
 */
@Service
public class MeetooGroupService {

    @Resource
    private MeetooGroupMapper meetooGroupMapper;

    @Resource
    private MeetooGroupMemberMapper meetooGroupMemberMapper;

    @Resource
    private MeetooUserService meetooUserService;

    @Resource
    private MeetooTopicService meetooTopicService;

    public MeetooGroup selectById(Integer id) {
        MeetooGroup group = meetooGroupMapper.selectById(id);
        if (group != null) {
            group.setGroupName(EmojiParser.parseToUnicode(group.getGroupName()));
            group.setIntro(EmojiParser.parseToUnicode(group.getIntro()));
            group.setMeetooUser(meetooUserService.selectById(group.getUserId()));
        }
        return group;
    }

    public List<MeetooGroup> selectByType(Integer type) {
        List<MeetooGroup> list = meetooGroupMapper.selectByType(type);
        transMeetooGroup(list);
        return list;
    }

    public List<MeetooGroup> selectUserGroups(Integer userId) {
        List<MeetooGroup> list = meetooGroupMapper.selectUserGroups(userId);
        transMeetooGroup(list);
        return list;
    }

    private void transMeetooGroup(List<MeetooGroup> list) {
        if (list != null && list.size() > 0) {
            for (MeetooGroup group : list) {
                group.setGroupName(EmojiParser.parseToUnicode(group.getGroupName()));
                group.setIntro(EmojiParser.parseToUnicode(group.getIntro()));
                group.setMeetooUser(meetooUserService.selectById(group.getUserId()));
            }
        }
    }

    public List<MeetooGroup> selectMineGroups(Integer userId) {
        List<MeetooGroup> list = meetooGroupMapper.selectMineGroups(userId);
        transMeetooGroup(list);
        return list;
    }

    public Integer insert(MeetooGroup record) {
        record.setGroupName(EmojiParser.parseToAliases(record.getGroupName()));
        record.setIntro(EmojiParser.parseToAliases(record.getIntro()));
        return meetooGroupMapper.insert(record);
    }

    public void update(MeetooGroup record) {
        record.setGroupName(EmojiParser.parseToAliases(record.getGroupName()));
        record.setIntro(EmojiParser.parseToAliases(record.getIntro()));
        meetooGroupMapper.update(record);
    }

    public void deleteById(Integer id) {
        meetooGroupMapper.deleteById(id);
        meetooGroupMemberMapper.deleteByGroupId(id);
        meetooTopicService.deleteByGroupId(id);
    }

    public Integer insertMeetooGroupMember(MeetooGroupMember meetooGroupMember) {
        return meetooGroupMemberMapper.insert(meetooGroupMember);
    }
}
