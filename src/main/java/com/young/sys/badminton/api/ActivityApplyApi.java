package com.young.sys.badminton.api;

import com.young.sys.badminton.domain.ActivityApplyMember;
import com.young.sys.badminton.model.AjaxResult;
import com.young.sys.badminton.service.ActivityApplyMemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author huyang8
 * TODO: 2018/12/06  活动报名api
 */
@Controller
@RequestMapping("/api/activityApply")
public class ActivityApplyApi extends BaseApi{

    @Resource
    private ActivityApplyMemberService activityApplyMemberService;

    @RequestMapping("/apply.do")
    @ResponseBody
    public AjaxResult apply(ActivityApplyMember activityApplyMember) {
        activityApplyMemberService.insert(activityApplyMember);
        return success();
    }

    @RequestMapping("/selectApplyMemberModel.do")
    @ResponseBody
    public AjaxResult selectApplyMemberModel(Integer activityId) {
        return successData(activityApplyMemberService.selectApplyMemberModel(activityId));
    }
}
