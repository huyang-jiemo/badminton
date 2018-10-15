package com.young.sys.badminton.service;

import com.young.sys.badminton.dao.ActivityMemberMapper;
import com.young.sys.badminton.domain.ActivityMember;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author huyang8
 * // TODO: 2018/10/15  活动人员service服务类
 */
@Service
public class ActivityMemberService {

    @Resource
    private ActivityMemberMapper activityMemberMapper;

    public List<ActivityMember> selectByActivityId(Integer activityId){
        return activityMemberMapper.selectByActivityId(activityId);
    }

    public void insert(ActivityMember activityMember){
        activityMemberMapper.insert(activityMember);
    }

    public void deleteById(Integer id){
        activityMemberMapper.deleteById(id);
    }
}
