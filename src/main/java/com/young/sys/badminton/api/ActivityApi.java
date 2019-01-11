package com.young.sys.badminton.api;

        import com.young.sys.badminton.domain.Activity;
        import com.young.sys.badminton.model.AjaxResult;
        import com.young.sys.badminton.service.ActivityService;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.ResponseBody;

        import javax.annotation.Resource;

/**
 * @author huyang8
 * TODO: 2018/12/06  活动api
 */
@Controller
@RequestMapping("/api/activity")
public class ActivityApi extends BaseApi{

    @Resource
    private ActivityService activityService;

    @RequestMapping("/publish.do")
    @ResponseBody
    public AjaxResult publish(Activity activity) {
        activityService.insert(activity);
        return success();
    }

    @RequestMapping("/selectThisWeek.do")
    @ResponseBody
    public AjaxResult selectThisWeek() {
        return successData(activityService.selectAllThisWeekModel());
    }

    @RequestMapping("/selectDetailModelById.do")
    @ResponseBody
    public AjaxResult selectDetailModelById(Integer activityId){
        return successData(activityService.selectDetailModelById(activityId));
    }

    @RequestMapping("/selectPast.do")
    @ResponseBody
    public AjaxResult selectPast() {
        return successData(activityService.selectPast());
    }

    @RequestMapping("/selectByClubId.do")
    @ResponseBody
    public AjaxResult selectByClubId(Integer clubId) {
        return successData(activityService.selectByClubId(clubId));
    }

    @RequestMapping("/selectMineApplyActivity.do")
    @ResponseBody
    public AjaxResult selectMineApplyActivity(Integer userId) {
        return successData(activityService.selectMineApplyActivity(userId));
    }
}
