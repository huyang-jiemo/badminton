package com.young.sys.badminton.service;

import com.young.sys.badminton.dao.ActivityMapper;
import com.young.sys.badminton.dao.ActivityMemberMapper;
import com.young.sys.badminton.dao.ClubMapper;
import com.young.sys.badminton.dao.UserMapper;
import com.young.sys.badminton.domain.Activity;
import com.young.sys.badminton.domain.Club;
import com.young.sys.badminton.model.ActivityModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
}
