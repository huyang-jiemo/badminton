package com.young.sys.badminton.api;

import com.young.sys.badminton.model.AjaxResult;
import com.young.sys.badminton.service.ActivityService;
import com.young.sys.badminton.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author huyang8
 * TODO: 2018/12/06  用户api
 */
@Controller
@RequestMapping("/api/user")
public class UserApi extends BaseApi{

    @Resource
    private UserService userService;

    @Resource
    private ActivityService activityService;

    @RequestMapping("/login.do")
    @ResponseBody
    public AjaxResult login(String openid){
        return successData(userService.selectByOpenid(openid));
    }

    @RequestMapping("/selectUserStat.do")
    @ResponseBody
    public AjaxResult selectUserStat(Integer userId){
        return successData(userService.selectUserStat(userId));
    }

    @RequestMapping("/selectMinePastActivity.do")
    @ResponseBody
    public AjaxResult selectMinePastActivity(Integer userId){
        return successData(activityService.selectMinePastActivity(userId));
    }
}
