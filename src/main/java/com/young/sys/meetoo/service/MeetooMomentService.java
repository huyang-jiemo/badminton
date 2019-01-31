package com.young.sys.meetoo.service;

import com.vdurmont.emoji.EmojiParser;
import com.young.sys.meetoo.dao.*;
import com.young.sys.meetoo.domain.MeetooMoment;
import com.young.sys.meetoo.domain.PageQuery;
import com.young.sys.meetoo.model.MeetooMomentModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author huyang8
 * @date 2019-01-24 14:34
 */
@Service
public class MeetooMomentService {

    @Resource
    private MeetooMomentMapper meetooMomentMapper;

    @Resource
    private MeetooMomentPicMapper meetooMomentPicMapper;

    @Resource
    private MeetooMomentMarkMapper meetooMomentMarkMapper;

    @Resource
    private MeetooMomentCommentService meetooMomentCommentService;

    @Resource
    private MeetooUserService meetooUserService;

    public Integer insert(MeetooMoment record){
        record.setEmotion(EmojiParser.parseToAliases(record.getEmotion()));
        return meetooMomentMapper.insert(record);
    }

    public void update(MeetooMoment record){
        meetooMomentMapper.update(record);
    }

    public List<MeetooMomentModel> selectNewMoment(PageQuery query) {
        return translateMomentModelList(meetooMomentMapper.selectNewPageMoment(query));
    }

    public List<MeetooMomentModel> selectHotMoment(PageQuery query) {
        return translateMomentModelList(meetooMomentMapper.selectHotPageMoment(query));
    }

    public MeetooMomentModel selectMomentById(Integer momentId){
        return translateMomentModel(meetooMomentMapper.selectById(momentId));
    }

    private List<MeetooMomentModel> translateMomentModelList(List<MeetooMoment> meetooMomentList){
        List<MeetooMomentModel> resultList = new ArrayList<>();
        if(meetooMomentList!=null&&meetooMomentList.size()>0){
            for(MeetooMoment meetooMoment:meetooMomentList){
                resultList.add(translateMomentModel(meetooMoment));
            }
        }
        return resultList;
    }

    private MeetooMomentModel translateMomentModel(MeetooMoment meetooMoment){
        MeetooMomentModel meetooMomentModel = new MeetooMomentModel();
        meetooMoment.setEmotion(EmojiParser.parseToUnicode(meetooMoment.getEmotion()));
        meetooMomentModel.setMeetooMoment(meetooMoment);
        meetooMomentModel.setMeetooUser(meetooUserService.selectById(meetooMoment.getUserId()));
        meetooMomentModel.setMeetooMomentPicList(meetooMomentPicMapper.selectPicByMomentId(meetooMoment.getId()));
        meetooMomentModel.setMeetooMomentMarkList(meetooMomentMarkMapper.selectMarkByMomentId(meetooMoment.getId()));
        meetooMomentModel.setMeetooMomentCommentList(meetooMomentCommentService.selectCommentByMomentId(meetooMoment.getId()));
        return meetooMomentModel;
    }

    public void saveMomentSee(Integer momentId) {
        MeetooMoment meetooMoment = meetooMomentMapper.selectById(momentId);
        int flag = meetooMoment.getFlag();
        meetooMoment.setFlag(flag+1);
        meetooMomentMapper.update(meetooMoment);
    }

    public List<MeetooMomentModel> selectUserMoments(Integer userId) {
        return translateMomentModelList(meetooMomentMapper.selectUserMoments(userId));
    }
}
