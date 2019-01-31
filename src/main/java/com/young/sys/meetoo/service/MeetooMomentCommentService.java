package com.young.sys.meetoo.service;

import com.vdurmont.emoji.EmojiParser;
import com.young.sys.meetoo.dao.MeetooMomentCommentMapper;
import com.young.sys.meetoo.domain.MeetooMomentComment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author huyang8
 * @date 2019-01-26 18:38
 */
@Service
public class MeetooMomentCommentService {

    @Resource
    private MeetooMomentCommentMapper meetooMomentCommentMapper;

    public List<MeetooMomentComment> selectCommentByMomentId(Integer momentId){
        List<MeetooMomentComment> list = meetooMomentCommentMapper.selectCommentByMomentId(momentId);
        for(MeetooMomentComment meetooMomentComment:list){
            meetooMomentComment.setWord(EmojiParser.parseToUnicode(meetooMomentComment.getWord()));
        }
        return list;
    }

    public void insert(MeetooMomentComment record){
        record.setWord(EmojiParser.parseToAliases(record.getWord()));
        meetooMomentCommentMapper.insert(record);
    }
}
