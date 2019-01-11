package com.young.sys.badminton.service;

import com.young.sys.badminton.dao.ActivityApplyMemberMapper;
import com.young.sys.badminton.dao.ActivityMapper;
import com.young.sys.badminton.dao.UserMapper;
import com.young.sys.badminton.domain.Activity;
import com.young.sys.badminton.domain.ActivityApplyMember;
import com.young.sys.badminton.model.ActivityApplyMemberModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huyang8
 * // TODO: 2018/10/15  活动人员service服务类
 */
@Service
public class ActivityApplyMemberService {

    @Resource
    private ActivityApplyMemberMapper activityApplyMemberMapper;

    @Resource
    private ActivityMapper activityMapper;

    @Resource
    private UserMapper userMapper;

    public List<ActivityApplyMember> selectByActivityId(Integer activityId){
        return activityApplyMemberMapper.selectByActivityId(activityId);
    }

    public void insert(ActivityApplyMember activityMember){
        activityApplyMemberMapper.insert(activityMember);
    }

    public void deleteById(Integer id){
        activityApplyMemberMapper.deleteById(id);
    }

    public List<ActivityApplyMemberModel> selectApplyMemberModel(Integer activityId) {
        List<ActivityApplyMemberModel> activityApplyMemberModelList = new ArrayList<>();
        List<ActivityApplyMember> activityApplyMembers = activityApplyMemberMapper.selectByActivityId(activityId);
        if(activityApplyMembers!=null&&activityApplyMembers.size()>0){
            for(ActivityApplyMember applyMember:activityApplyMembers){
                ActivityApplyMemberModel applyMemberModel = new ActivityApplyMemberModel();
                applyMemberModel.setActivity(activityMapper.selectById(applyMember.getActivityId()));
                applyMemberModel.setUser(userMapper.selectById(applyMember.getUserId()));
                applyMemberModel.setActivityApplyMember(applyMember);
                activityApplyMemberModelList.add(applyMemberModel);
            }
        }
        return activityApplyMemberModelList;
    }

    public void cancelApply(Integer activityId, Integer userId) {
        activityApplyMemberMapper.cancelApply(activityId,userId);
    }
}
