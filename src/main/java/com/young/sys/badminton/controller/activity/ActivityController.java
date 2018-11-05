package com.young.sys.badminton.controller.activity;

import com.young.sys.badminton.controller.base.BaseController;
import com.young.sys.badminton.domain.Activity;
import com.young.sys.badminton.domain.ActivityMember;
import com.young.sys.badminton.model.ActivityModel;
import com.young.sys.badminton.service.ActivityMemberService;
import com.young.sys.badminton.service.ActivityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author huyang8
 * // TODO: 2018/10/9  活动controller
 */
@Controller
@RequestMapping("")
public class ActivityController extends BaseController {

    @Resource
    private ActivityService activityService;

    @Resource
    private ActivityMemberService activityMemberService;

    /**
     * 跳转主页
     */
    @RequestMapping("/activity.do")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        List<ActivityModel> activityModelList = activityService.selectAllActivityModel();
        mv.addObject("activityModelList",activityModelList);
        mv.setViewName("/activity/index");
        return mv;
    }

    @RequestMapping("/activity/activityDetail.do")
    public ModelAndView activityDetail(Integer id){
        ModelAndView mv = new ModelAndView();
        ActivityModel activityModel = activityService.selectActivityModelById(id);
        mv.addObject("activityModel",activityModel);
        mv.setViewName("/activity/detail");
        return mv;
    }

    @RequestMapping("/activity/activityPublish.do")
    public String activityPublish(){
        return "/activity/publish";
    }

    @RequestMapping("/activity/saveActivityAdd.do")
    public ModelAndView saveActivityAdd(Integer clubId,String activityDate,String startTime,String endTime,Integer limitMember,String activityAddress,String activityMemo){
        Activity activity = new Activity();
        activity.setClubId(clubId);
        activity.setActivityDate(activityDate);
        activity.setStartTime(startTime);
        activity.setEndTime(endTime);
        activity.setLimitMember(limitMember);
        activity.setActivityAddress(activityAddress);
        activity.setActivityMemo(activityMemo);
        activityService.insert(activity);
        return new ModelAndView(new RedirectView("/activity.do"));
    }

    @RequestMapping("/activity/saveActivityMemberApply.do")
    public ModelAndView saveActivityMemberApply(Integer activityId,String nick,Integer memberNum,Integer memberSex,Long memberPhone){
        ActivityMember activityMember = new ActivityMember();
        activityMember.setActivityId(activityId);
        activityMember.setNick(nick);
        activityMember.setMemberNum(memberNum);
        activityMember.setMemberSex(memberSex);
        activityMember.setMemberPhone(memberPhone);
        activityMemberService.insert(activityMember);
        return new ModelAndView(new RedirectView("/activity/activityDetail.do?id="+activityId));
    }
}
