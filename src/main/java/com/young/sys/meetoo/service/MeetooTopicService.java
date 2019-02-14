package com.young.sys.meetoo.service;

import com.vdurmont.emoji.EmojiParser;
import com.young.sys.meetoo.dao.MeetooTopicMapper;
import com.young.sys.meetoo.domain.MeetooTopic;
import com.young.sys.meetoo.model.MeetooTopicModel;
import org.codehaus.plexus.util.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huyang8
 * @date 2019-02-13 15:10
 */
@Service
public class MeetooTopicService {

    @Resource
    private MeetooTopicMapper meetooTopicMapper;

    @Resource
    private MeetooTopicCommentService meetooTopicCommentService;

    @Resource
    private MeetooUserService meetooUserService;

    public MeetooTopicModel selectMeetooTopicModelById(Integer id) {
        MeetooTopic meetooTopic = meetooTopicMapper.selectById(id);
        return translateTopicModel(meetooTopic);
    }

    public List<MeetooTopicModel> selectMeetooTopicModelByGroupId(Integer groupId) {
        List<MeetooTopicModel> meetooTopicModelList = new ArrayList<>();
        List<MeetooTopic> meetooTopicList = meetooTopicMapper.selectByGroupId(groupId);
        if (meetooTopicList != null && meetooTopicList.size() > 0) {
            for (MeetooTopic meetooTopic : meetooTopicList) {
                meetooTopicModelList.add(translateTopicModel(meetooTopic));
            }
        }
        return meetooTopicModelList;
    }

    public List<MeetooTopicModel> selectGroupMyTopic(Integer groupId, Integer userId) {
        List<MeetooTopicModel> meetooTopicModelList = new ArrayList<>();
        List<MeetooTopic> meetooTopicList = meetooTopicMapper.selectGroupMyTopic(groupId, userId);
        if (meetooTopicList != null && meetooTopicList.size() > 0) {
            for (MeetooTopic meetooTopic : meetooTopicList) {
                meetooTopicModelList.add(translateTopicModel(meetooTopic));
            }
        }
        return meetooTopicModelList;
    }

    private MeetooTopicModel translateTopicModel(MeetooTopic meetooTopic) {
        MeetooTopicModel meetooTopicModel = new MeetooTopicModel();
        meetooTopic.setTopic(EmojiParser.parseToUnicode(meetooTopic.getTopic()));
        meetooTopicModel.setMeetooTopic(meetooTopic);
        meetooTopicModel.setMeetooUser(meetooUserService.selectById(meetooTopic.getUserId()));
        meetooTopicModel.setMeetooTopicCommentList(meetooTopicCommentService.selectByTopicId(meetooTopic.getId()));
        if (StringUtils.isNotEmpty(meetooTopic.getPictures())) {
            String pics = meetooTopic.getPictures();
            pics = pics.substring(0, pics.lastIndexOf("&"));
            meetooTopicModel.setMeetooTopicPicList(Arrays.asList(pics.split("&")));
        } else {
            meetooTopicModel.setMeetooTopicPicList(new ArrayList<String>());
        }
        return meetooTopicModel;
    }

    public MeetooTopic selectById(Integer id) {
        return meetooTopicMapper.selectById(id);
    }

    public Integer insert(MeetooTopic record) {
        record.setTopic(EmojiParser.parseToAliases(record.getTopic()));
        return meetooTopicMapper.insert(record);
    }

    public void updateTopicPicture(MeetooTopic record) {
        meetooTopicMapper.updateTopicPicture(record);
    }

    public void deleteById(Integer id) {
        meetooTopicMapper.deleteById(id);
        meetooTopicCommentService.deleteByTopicId(id);
    }

    public void deleteByGroupId(Integer groupId) {
        List<MeetooTopic> list = meetooTopicMapper.selectByGroupId(groupId);
        if (list != null && list.size() > 0) {
            for (MeetooTopic topic : list) {
                meetooTopicCommentService.deleteByTopicId(topic.getId());
            }
        }
        meetooTopicMapper.deleteByGroupId(groupId);

    }


}
