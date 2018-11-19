package com.young.sys.badminton.service;

import com.young.sys.badminton.api.ActivityApi;
import com.young.sys.badminton.dao.ActivityMapper;
import com.young.sys.badminton.dao.ActivityMemberMapper;
import com.young.sys.badminton.dao.ClubMapper;
import com.young.sys.badminton.dao.UserMapper;
import com.young.sys.badminton.domain.Activity;
import com.young.sys.badminton.domain.ActivityMember;
import com.young.sys.badminton.domain.Club;
import com.young.sys.badminton.model.ActivityApiModel;
import com.young.sys.badminton.model.ActivityModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
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
    private ActivityMapper activityMapper;

    @Resource
    private ClubMapper clubMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private ActivityMemberMapper activityMemberMapper;

    public List<Activity> selectAll(){
        return activityMapper.selectAll();
    }

    public List<Activity> selectAllPast(){
        return activityMapper.selectAllPast();
    }

    public List<Activity> selectAllFuture(){
        return activityMapper.selectAllFuture();
    }
    
    public List<Activity> selectByClubId(Integer clubId){
        return activityMapper.selectByClubId(clubId);
    }

    public List<ActivityApiModel> selectApiModelByDate(String date){
        return translateToApiModelList(activityMapper.selectByDate(date));
    }

    public ActivityApiModel selectApiModelById(Integer id){
        return translateToApiModel(activityMapper.selectById(id));
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

    public List<ActivityModel> selectAllActivityModel(){
        return this.translateToModel(activityMapper.selectAll());
    }

    public List<ActivityModel> selectAllFutureActivityModel(){
        return this.translateToModel(activityMapper.selectAllFuture());
    }

    public ActivityModel selectActivityModelById(Integer id){
        Activity activity = activityMapper.selectById(id);
        ActivityModel activityModel = new ActivityModel();
        activityModel.setActivity(activity);
        Club club = clubMapper.selectById(activity.getClubId());
        activityModel.setClub(club);
        activityModel.setUser(userMapper.selectById(club.getClubUserId()));
        activityModel.setActivityMemberList(activityMemberMapper.selectByActivityId(activity.getId()));
        return activityModel;
    }

    private List<ActivityModel> translateToModel(List<Activity> activityList){
        List<ActivityModel> activityModelList = new ArrayList<>();
        if(activityList!=null&&activityList.size()>0){
            for(Activity activity:activityList){
                ActivityModel activityModel = new ActivityModel();
                activityModel.setActivity(activity);
                Club club = clubMapper.selectById(activity.getClubId());
                activityModel.setClub(club);
                activityModel.setUser(userMapper.selectById(club.getClubUserId()));
                activityModel.setActivityMemberList(activityMemberMapper.selectByActivityId(activity.getId()));
                activityModelList.add(activityModel);
            }
        }
        return activityModelList;
    }

    private ActivityApiModel translateToApiModel(Activity activity){
        ActivityApiModel activityApiModel = new ActivityApiModel();
        activityApiModel.setId(activity.getId());
        activityApiModel.setLimitMember(activity.getLimitMember());
        activityApiModel.setActivityAddress(activity.getActivityAddress());
        activityApiModel.setActivityStatus(judgeActivityTime(activity));
        String startTime = activity.getStartTime();
        String endTime = activity.getEndTime();
        activityApiModel.setStartTime(startTime.substring(0,startTime.lastIndexOf(":")));
        activityApiModel.setEndTime(endTime.substring(0,endTime.lastIndexOf(":")));
        Club club = clubMapper.selectById(activity.getClubId());
        activityApiModel.setClubName(club.getClubName());
        List<ActivityMember> activityMemberList = activityMemberMapper.selectByActivityId(activity.getId());
        if(activityMemberList!=null&&activityMemberList.size()>0){
            activityApiModel.setApplyMember(activityMemberList.size());
        }else{
            activityApiModel.setApplyMember(0);
        }
        return activityApiModel;
    }

    private List<ActivityApiModel> translateToApiModelList(List<Activity> activityList){
        List<ActivityApiModel> activityApiModelList = new ArrayList<>();
        if(activityList!=null&&activityList.size()>0){
            for(Activity activity:activityList){
                activityApiModelList.add(translateToApiModel(activity));
            }
        }
        return activityApiModelList;
    }

    private static final SimpleDateFormat SDF_DATE = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private int judgeActivityTime(Activity activity){
        int result = 1;
        String startDate = activity.getActivityDate()+" "+activity.getStartTime();
        String endDate = activity.getActivityDate()+" "+activity.getEndTime();
        try {
            Date begin = SDF_DATE.parse(startDate);
            Date end = SDF_DATE.parse(endDate);
            Date now = new Date();
            if(now.after(end)){
                result=3;
            }
            if(now.compareTo(begin)>=0&&now.compareTo(end)<=0){
                result=2;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
