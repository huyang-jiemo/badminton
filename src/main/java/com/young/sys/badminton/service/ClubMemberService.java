package com.young.sys.badminton.service;

import com.young.sys.badminton.dao.ClubMapper;
import com.young.sys.badminton.dao.ClubMemberMapper;
import com.young.sys.badminton.dao.UserMapper;
import com.young.sys.badminton.domain.ClubMember;
import com.young.sys.badminton.model.ClubMemberModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huyang8
 * // TODO: 2018/10/9  俱乐部成员service服务类
 */
@Service
public class ClubMemberService {

    @Resource
    private ClubMemberMapper clubMemberMapper;

    @Resource
    private ClubMapper clubMapper;

    @Resource
    private UserMapper userMapper;

    public List<ClubMember> selectByClubId(Integer clubId){
        return clubMemberMapper.selectByClubId(clubId);
    }

    public ClubMember selectById(Integer id){
        return clubMemberMapper.selectById(id);
    }

    public void insert(ClubMember clubMember){
        clubMemberMapper.insert(clubMember);
    }

    public void update(ClubMember clubMember){
        clubMemberMapper.update(clubMember);
    }

    public void deleteById(Integer id){
        clubMemberMapper.deleteById(id);
    }

    public List<ClubMemberModel> selectModelByClubId(Integer clubId){
        List<ClubMemberModel> resultList = new ArrayList<>();
        List<ClubMember> clubMemberList = clubMemberMapper.selectByClubId(clubId);
        if(clubMemberList!=null&&clubMemberList.size()>0){
            for(ClubMember clubMember : clubMemberList){
                ClubMemberModel clubMemberModel = new ClubMemberModel();
                clubMemberModel.setClub(clubMapper.selectById(clubMember.getClubId()));
                clubMemberModel.setUser(userMapper.selectById(clubMember.getUserId()));
                clubMemberModel.setClubMember(clubMember);
                resultList.add(clubMemberModel);
            }
        }
        return resultList;
    }

    public void removeMember(Integer userId, Integer clubId) {
        clubMemberMapper.removeMember(userId,clubId);
    }
}
