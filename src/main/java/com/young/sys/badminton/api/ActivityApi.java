package com.young.sys.badminton.api;

import com.young.sys.badminton.model.AjaxResult;
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

    @RequestMapping("/query.do")
    @ResponseBody
    public AjaxResult query(String date){
        String queryDate = date.replace("/","-");
        return successData(activityService.selectApiModelByDate(queryDate));
    }

    @RequestMapping("/queryById.do")
    @ResponseBody
    public AjaxResult query(Integer id){
        return successData(activityService.selectActivityModelById(id));
    }
}
