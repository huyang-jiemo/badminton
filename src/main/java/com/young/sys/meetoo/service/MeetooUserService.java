package com.young.sys.meetoo.service;

import com.vdurmont.emoji.EmojiParser;
import com.young.sys.meetoo.dao.MeetooUserMapper;
import com.young.sys.meetoo.domain.MeetooUser;
import com.young.sys.meetoo.model.MeetooUserStatisticModel;
import org.codehaus.plexus.util.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author huyang8
 * @date 2019-01-23 16:53
 */
@Service
public class MeetooUserService {

    @Resource
    private MeetooUserMapper meetooUserMapper;

    public MeetooUser selectById(Integer id){
        MeetooUser user = meetooUserMapper.selectById(id);
        if(user!=null){
            if(StringUtils.isNotEmpty(user.getNick())){
                user.setNick(EmojiParser.parseToUnicode(user.getNick()));
            }
            user.setSignature(EmojiParser.parseToUnicode(user.getSignature()));
        }
        return user;
    }

    public MeetooUser selectByOpenId(String openid){
        MeetooUser user = meetooUserMapper.selectByOpenId(openid);
        if(user!=null){
            if(StringUtils.isNotEmpty(user.getNick())){
                user.setNick(EmojiParser.parseToUnicode(user.getNick()));
            }
            user.setSignature(EmojiParser.parseToUnicode(user.getSignature()));
        }
        return user;
    }

    public Integer insert(MeetooUser record){
        record.setNick(EmojiParser.parseToAliases(record.getNick()));
        record.setSignature(EmojiParser.parseToAliases(record.getSignature()));
        return meetooUserMapper.insert(record);
    }

    public void update(MeetooUser record){
        record.setNick(EmojiParser.parseToAliases(record.getNick()));
        record.setSignature(EmojiParser.parseToAliases(record.getSignature()));
        meetooUserMapper.update(record);
    }

    public MeetooUserStatisticModel selectUserStatistic(Integer userId){
        return meetooUserMapper.selectUserStatistic(userId);
    }
}
