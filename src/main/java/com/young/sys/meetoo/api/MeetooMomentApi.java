package com.young.sys.meetoo.api;

import com.young.sys.badminton.model.AjaxResult;
import com.young.sys.badminton.util.DateUtil;
import com.young.sys.badminton.util.FileUploadUtil;
import com.young.sys.meetoo.domain.*;
import com.young.sys.meetoo.service.MeetooMomentCommentService;
import com.young.sys.meetoo.service.MeetooMomentMarkService;
import com.young.sys.meetoo.service.MeetooMomentPicService;
import com.young.sys.meetoo.service.MeetooMomentService;
import org.codehaus.plexus.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author huyang8
 * @date 2019-01-24 14:35
 */
@Controller
@RequestMapping("/api/meetoo/moment")
public class MeetooMomentApi extends MeetooBaseApi{

    @Resource
    private MeetooMomentService meetooMomentService;

    @Resource
    private MeetooMomentPicService meetooMomentPicService;

    @Resource
    private MeetooMomentMarkService meetooMomentMarkService;

    @Resource
    private MeetooMomentCommentService meetooMomentCommentService;

    @RequestMapping("/publish.do")
    @ResponseBody
    public AjaxResult publish(MeetooMoment meetooMoment){
        MeetooMoment meetooMomentDB = new MeetooMoment();
        meetooMomentDB.setEmotion(meetooMoment.getEmotion());
        meetooMomentDB.setUserId(meetooMoment.getUserId());
        if(StringUtils.isNotEmpty(meetooMoment.getAddress())){
            meetooMomentDB.setAddress(meetooMoment.getAddress());
        }
        meetooMomentDB.setCreateTime(DateUtil.getNow());
        meetooMomentService.insert(meetooMomentDB);
        return successData(meetooMomentDB);
    }

    @RequestMapping("/uploadMomentPic.do")
    @ResponseBody
    public AjaxResult uploadMomentPic(Integer momentId, HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file) {
        MeetooMomentPic meetooMomentPic = new MeetooMomentPic();
        meetooMomentPic.setMomentId(momentId);
        meetooMomentPic.setUrl(FileUploadUtil.uploadFile(file, request, "meetoo_moment"));
        meetooMomentPic.setCreateTime(DateUtil.getNow());
        meetooMomentPicService.insert(meetooMomentPic);
        return success();
    }

    @RequestMapping("/selectNewMoment.do")
    @ResponseBody
    public AjaxResult selectNewMoment(PageQuery query){
        return successData(meetooMomentService.selectNewMoment(query));
    }

    @RequestMapping("/selectHotMoment.do")
    @ResponseBody
    public AjaxResult selectHotMoment(PageQuery query){
        return successData(meetooMomentService.selectHotMoment(query));
    }

    @RequestMapping("/selectMomentDetail.do")
    @ResponseBody
    public AjaxResult selectMomentDetail(Integer momentId){
        return successData(meetooMomentService.selectMomentById(momentId));
    }

    @RequestMapping("/saveMomentSee.do")
    @ResponseBody
    public AjaxResult saveMomentSee(Integer momentId){
        meetooMomentService.saveMomentSee(momentId);
        return success();
    }

    @RequestMapping("/saveMomentMark.do")
    @ResponseBody
    public AjaxResult saveMomentMark(Integer momentId,Integer userId){
        MeetooMomentMark meetooMomentMarkDB = meetooMomentMarkService.selectMarkByMomentIdAndUserId(momentId,userId);
        if(meetooMomentMarkDB!=null){
            return failMessage(null);
        }else{
            MeetooMomentMark meetooMomentMark = new MeetooMomentMark();
            meetooMomentMark.setMomentId(momentId);
            meetooMomentMark.setUserId(userId);
            meetooMomentMark.setCreateTime(DateUtil.getNow());
            meetooMomentMarkService.insert(meetooMomentMark);
            return success();
        }
    }

    @RequestMapping("/saveMomentComment.do")
    @ResponseBody
    public AjaxResult saveMomentComment(Integer momentId,Integer userId,String word){
        MeetooMomentComment meetooMomentComment = new MeetooMomentComment();
        meetooMomentComment.setMomentId(momentId);
        meetooMomentComment.setUserId(userId);
        meetooMomentComment.setWord(word);
        meetooMomentComment.setCreateTime(DateUtil.getNow());
        meetooMomentCommentService.insert(meetooMomentComment);
        return success();
    }

    @RequestMapping("/selectUserMoments.do")
    @ResponseBody
    public AjaxResult selectUserMoments(Integer userId){
        return successData(meetooMomentService.selectUserMoments(userId));
    }
}
