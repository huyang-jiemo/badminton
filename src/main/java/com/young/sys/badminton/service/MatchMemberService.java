package com.young.sys.badminton.service;

import com.young.sys.badminton.dao.MatchMemberMapper;
import com.young.sys.badminton.domain.MatchMember;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author huyang8
 * // TODO: 2018/10/25  比赛成员service服务类
 */
@Service
public class MatchMemberService {

    @Resource
    private MatchMemberMapper matchMemberMapper;

    public List<MatchMember> selectAll(){
        return matchMemberMapper.selectAll();
    }

    public MatchMember selectById(Integer id){
       return  matchMemberMapper.selectById(id);
    }

    public void insert(MatchMember matchMember){
        matchMemberMapper.insert(matchMember);
    }

    public void update(MatchMember matchMember){
        matchMemberMapper.update(matchMember);
    }

    public void deleteById(Integer id){
        matchMemberMapper.deleteById(id);
    }
}
