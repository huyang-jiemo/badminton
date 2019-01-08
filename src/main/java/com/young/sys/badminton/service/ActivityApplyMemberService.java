package com.young.sys.badminton.service;

import com.young.sys.badminton.dao.ActivityApplyMemberMapper;
import com.young.sys.badminton.domain.ActivityApplyMember;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author huyang8
 * // TODO: 2018/10/15  活动人员service服务类
 */
@Service
public class ActivityApplyMemberService {

    @Resource
    private ActivityApplyMemberMapper activityApplyMemberMapper;

    public List<ActivityApplyMember> selectByActivityId(Integer activityId){
        return activityApplyMemberMapper.selectByActivityId(activityId);
    }

    public void insert(ActivityApplyMember activityMember){
        activityApplyMemberMapper.insert(activityMember);
    }

    public void deleteById(Integer id){
        activityApplyMemberMapper.deleteById(id);
    }
}
