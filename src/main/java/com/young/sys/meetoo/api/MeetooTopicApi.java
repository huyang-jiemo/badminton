package com.young.sys.meetoo.api;

import com.young.sys.badminton.model.AjaxResult;
import com.young.sys.badminton.util.DateUtil;
import com.young.sys.badminton.util.FileUploadUtil;
import com.young.sys.meetoo.domain.MeetooTopic;
import com.young.sys.meetoo.domain.MeetooTopicComment;
import com.young.sys.meetoo.service.MeetooTopicCommentService;
import com.young.sys.meetoo.service.MeetooTopicService;
import org.codehaus.plexus.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author huyang8
 * @date 2019-02-13 15:34
 */
@Controller
@RequestMapping("/api/meetoo/topic")
public class MeetooTopicApi extends MeetooBaseApi {

    @Resource
    private MeetooTopicService meetooTopicService;

    @Resource
    private MeetooTopicCommentService meetooTopicCommentService;

    @RequestMapping("/selectTopicDetail.do")
    @ResponseBody
    public AjaxResult selectTopicDetail(Integer topicId) {
        return successData(meetooTopicService.selectMeetooTopicModelById(topicId));
    }

    @RequestMapping("/selectByGroupId.do")
    @ResponseBody
    public AjaxResult selectByGroupId(Integer groupId) {
        return successData(meetooTopicService.selectMeetooTopicModelByGroupId(groupId));
    }

    @RequestMapping("/publish.do")
    @ResponseBody
    public AjaxResult publish(MeetooTopic meetooTopic) {
        meetooTopic.setCreateTime(DateUtil.getNow());
        meetooTopicService.insert(meetooTopic);
        return successData(meetooTopic);
    }

    @RequestMapping("/uploadTopicPic.do")
    @ResponseBody
    public AjaxResult uploadMomentPic(Integer topicId, HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file) {
        MeetooTopic meetooTopic = meetooTopicService.selectById(topicId);
        String url = FileUploadUtil.uploadFile(file, request, "meetoo_topic");
        String dbUrl = meetooTopic.getPictures();
        if(StringUtils.isNotEmpty(dbUrl)){
            dbUrl = dbUrl + url + "&";
        }else{
            dbUrl = url + "&";
        }
        meetooTopic.setPictures(dbUrl);
        meetooTopicService.updateTopicPicture(meetooTopic);
        return success();
    }

    @RequestMapping("/saveTopicComment.do")
    @ResponseBody
    public AjaxResult saveTopicComment(MeetooTopicComment meetooTopicComment){
        meetooTopicComment.setCreateTime(DateUtil.getNow());
        meetooTopicCommentService.insert(meetooTopicComment);
        return success();
    }
}
