package com.young.sys.meetoo.service;

import com.vdurmont.emoji.EmojiParser;
import com.young.sys.meetoo.dao.MeetooUserRelationMapper;
import com.young.sys.meetoo.domain.MeetooUser;
import com.young.sys.meetoo.domain.MeetooUserRelation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author huyang8
 * @date 2019-01-29 16:46
 */
@Service
public class MeetooUserRelationService {

    @Resource
    private MeetooUserRelationMapper meetooUserRelationMapper;

    public MeetooUserRelation selectIsFan(Integer fanUserId, Integer followUserId){
        return meetooUserRelationMapper.selectIsFan(fanUserId,followUserId);
    }

    public Integer insert(MeetooUserRelation record){
        return meetooUserRelationMapper.insert(record);
    }

    public void deleteRelation(Integer fanUserId, Integer followUserId){
        meetooUserRelationMapper.deleteRelation(fanUserId,followUserId);
    }

    public List<MeetooUser> selectUserFollows(Integer userId) {
        List<MeetooUser> list = meetooUserRelationMapper.selectUserFollows(userId);
        if(list!=null&&list.size()>0){
            for(MeetooUser user : list){
                user.setNick(EmojiParser.parseToUnicode(user.getNick()));
                user.setSignature(EmojiParser.parseToUnicode(user.getSignature()));
            }
        }
        return list;
    }

    public List<MeetooUser> selectUserFans(Integer userId) {
        List<MeetooUser> list = meetooUserRelationMapper.selectUserFans(userId);
        if(list!=null&&list.size()>0){
            for(MeetooUser user : list){
                user.setNick(EmojiParser.parseToUnicode(user.getNick()));
                user.setSignature(EmojiParser.parseToUnicode(user.getSignature()));
            }
        }
        return list;
    }
}
