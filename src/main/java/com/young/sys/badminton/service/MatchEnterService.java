package com.young.sys.badminton.service;

import com.young.sys.badminton.dao.MatchEnterMapper;
import com.young.sys.badminton.domain.MatchEnter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author huyang8
 * // TODO: 2018/10/26  比赛报名service服务类
 */
@Service
public class MatchEnterService {

    @Resource
    private MatchEnterMapper matchEnterMapper;

    public List<MatchEnter> selectByMatchId(Integer matchId){
        return matchEnterMapper.selectByMatchId(matchId);
    }

    public void insert(MatchEnter matchEnter){
        matchEnterMapper.insert(matchEnter);
    }

    public void deleteById(Integer id){
        matchEnterMapper.deleteById(id);
    }
}
