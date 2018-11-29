package com.young.sys.badminton.api;

import com.young.sys.badminton.domain.ActivityMember;
import com.young.sys.badminton.model.AjaxResult;
import com.young.sys.badminton.service.ActivityMemberService;
import com.young.sys.badminton.service.ActivityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author huyang8
 * // TODO: 2018/10/9  俱乐部controller
 */
@Controller
@RequestMapping("/api/activity")
public class ActivityApi extends BaseApi{

    @Resource
    private ActivityService activityService;

    @Resource
    private ActivityMemberService activityMemberService;

    @RequestMapping("/query.do")
    @ResponseBody
    public AjaxResult query(String date){
        String[] dateArray = date.split("/");
        String queryDate = translate(dateArray[0])+"-"+translate(dateArray[1])+"-"+translate(dateArray[2]);
        return successData(activityService.selectApiModelByDate(queryDate));
    }

    @RequestMapping("/queryById.do")
    @ResponseBody
    public AjaxResult query(Integer id){
        return successData(activityService.selectActivityModelById(id));
    }

    @RequestMapping("/apply.do")
    @ResponseBody
    public AjaxResult apply(ActivityMember activityMember){
        activityMemberService.insert(activityMember);
        return success();
    }

    private static String translate(String dateStr){
        if(Integer.parseInt(dateStr)<10){
            return "0"+dateStr;
        }else{
            return dateStr;
        }
    }
}
