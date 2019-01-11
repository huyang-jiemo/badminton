package com.young.sys.badminton.service;

import com.young.sys.badminton.dao.ActivityMapper;
import com.young.sys.badminton.dao.ActivityApplyMemberMapper;
import com.young.sys.badminton.dao.ClubMapper;
import com.young.sys.badminton.dao.UserMapper;
import com.young.sys.badminton.domain.Activity;
import com.young.sys.badminton.domain.Club;
import com.young.sys.badminton.model.ActivityDetailModel;
import com.young.sys.badminton.model.ActivityModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author huyang8
 * // TODO: 2018/10/9  活动service服务类
 */
@Service
public class ActivityService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private ClubMapper clubMapper;

    @Resource
    private ActivityMapper activityMapper;

    @Resource
    private ActivityApplyMemberMapper activityMemberMapper;

    public List<Activity> selectAll(){
        return activityMapper.selectAll();
    }

    public List<Activity> selectByClubId(Integer clubId){
        return activityMapper.selectByClubId(clubId);
    }

    public Activity selectById(Integer id){
        return activityMapper.selectById(id);
    }

    public void insert(Activity activity){
        activityMapper.insert(activity);
    }

    public void update(Activity activity){
        activityMapper.update(activity);
    }

    public void deleteById(Integer id){
        activityMapper.deleteById(id);
    }

    public List<Activity> selectAllThisWeek(){
        return activityMapper.selectAllThisWeek();
    }

    public List<ActivityModel> selectAllThisWeekModel(){
        List<ActivityModel> activityModelList = new ArrayList<>();
        List<Activity> activityList = activityMapper.selectAllThisWeek();
        exchangeToModel(activityModelList, activityList);
        return activityModelList;
    }

    public ActivityDetailModel selectDetailModelById(Integer id){
        ActivityDetailModel detailModel = new ActivityDetailModel();
        Activity activity = activityMapper.selectById(id);
        Club club = clubMapper.selectById(activity.getClubId());
        detailModel.setClub(club);
        detailModel.setUser(userMapper.selectById(club.getUserId()));
        detailModel.setActivity(activity);
        detailModel.setActivityApplyMemberList(activityMemberMapper.selectByActivityId(id));
        detailModel.setActivityStatus(calateActivityStatus(activity));
        return detailModel;
    }

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private Integer calateActivityStatus(Activity activity){
        String now = SIMPLE_DATE_FORMAT.format(new Date());
        String startDate = activity.getActivityDate()+" "+activity.getStartTime();
        String endDate = activity.getActivityDate()+" "+activity.getEndTime();
        if(now.compareTo(startDate)<0){
            return 1;
        }else if(now.compareTo(startDate)>=0&&now.compareTo(endDate)<=0){
            return 2;
        }else{
            return 3;
        }
    }

    public List<ActivityModel> selectPast() {
        List<ActivityModel> activityModelList = new ArrayList<>();
        List<Activity> activityList = activityMapper.selectPast();
        exchangeToModel(activityModelList, activityList);
        return activityModelList;
    }

    private void exchangeToModel(List<ActivityModel> activityModelList, List<Activity> activityList) {
        if(activityList!=null&&activityList.size()>0){
            for(Activity activity:activityList){
                ActivityModel activityModel = new ActivityModel();
                activityModel.setClub(clubMapper.selectById(activity.getClubId()));
                activityModel.setActivity(activity);
                activityModel.setActivityStatus(calateActivityStatus(activity));
                activityModelList.add(activityModel);
            }
        }
    }

    public List<ActivityModel> selectMinePastActivity(Integer userId){
        List<ActivityModel> activityModelList = new ArrayList<>();
        List<Activity> activityList = activityMapper.selectMinePastActivity(userId);
        exchangeToModel(activityModelList, activityList);
        return activityModelList;
    }

    public List<ActivityModel> selectMineApplyActivity(Integer userId) {
        List<ActivityModel> activityModelList = new ArrayList<>();
        List<Activity> activityList = activityMapper.selectMineApplyActivity(userId);
        exchangeToModel(activityModelList, activityList);
        return activityModelList;
    }
}
