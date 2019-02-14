package com.young.sys.meetoo.service;

import com.vdurmont.emoji.EmojiParser;
import com.young.sys.meetoo.dao.MeetooTopicCommentMapper;
import com.young.sys.meetoo.domain.MeetooTopicComment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author huyang8
 * @date 2019-02-13 15:22
 */
@Service
public class MeetooTopicCommentService {

    @Resource
    private MeetooTopicCommentMapper meetooTopicCommentMapper;

    public List<MeetooTopicComment> selectByTopicId(Integer topicId){
        List<MeetooTopicComment> list = meetooTopicCommentMapper.selectByTopicId(topicId);
        if(list!=null&&list.size()>0){
            for(MeetooTopicComment meetooTopicComment:list){
                meetooTopicComment.setWord(EmojiParser.parseToUnicode(meetooTopicComment.getWord()));
                meetooTopicComment.setNick(EmojiParser.parseToUnicode(meetooTopicComment.getNick()));
            }
        }
        return list;
    }

    public Integer insert(MeetooTopicComment record){
        record.setWord(EmojiParser.parseToAliases(record.getWord()));
        return meetooTopicCommentMapper.insert(record);
    }

    public void deleteById(Integer id){
        meetooTopicCommentMapper.deleteById(id);
    }

    public void deleteByTopicId(Integer topicId){
        meetooTopicCommentMapper.deleteByTopicId(topicId);
    }
}
