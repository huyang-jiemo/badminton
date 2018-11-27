package com.young.sys.badminton.service;

import com.young.sys.badminton.dao.ActivityMapper;
import com.young.sys.badminton.dao.ClubMapper;
import com.young.sys.badminton.dao.UserMapper;
import com.young.sys.badminton.domain.Activity;
import com.young.sys.badminton.domain.Club;
import com.young.sys.badminton.domain.User;
import com.young.sys.badminton.model.ClubApiModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author huyang8
 * // TODO: 2018/10/9  俱乐部service服务类
 */
@Service
public class ClubService {

    @Resource
    private ClubMapper clubMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private ActivityMapper activityMapper;

    public List<Club> selectAll(){
        return clubMapper.selectAll();
    }

    public Club selectById(Integer id){
        return clubMapper.selectById(id);
    }

    public void insert(Club club){
        clubMapper.insert(club);
    }

    public void update(Club club){
        clubMapper.update(club);
    }

    public void deleteById(Integer id){
        clubMapper.deleteById(id);
    }

    public ClubApiModel selectApiModelById(Integer id){
        ClubApiModel clubApiModel = new ClubApiModel();
        Club club = clubMapper.selectById(id);
        clubApiModel.setClub(club);
        User user = userMapper.selectById(club.getClubUserId());
        clubApiModel.setUser(user);
        //本周活动
        List<Activity> activityList = activityMapper.selectThisWeekByClub(club.getId());
        clubApiModel.setActivityList(activityList);
        return clubApiModel;
    }
}
