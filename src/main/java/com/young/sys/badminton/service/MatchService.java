package com.young.sys.badminton.service;

import com.young.sys.badminton.dao.ClubMapper;
import com.young.sys.badminton.dao.MatchEnterMapper;
import com.young.sys.badminton.dao.MatchMapper;
import com.young.sys.badminton.dao.MatchMemberMapper;
import com.young.sys.badminton.domain.Match;
import com.young.sys.badminton.model.MatchModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huyang8
 * // TODO: 2018/10/25  比赛service服务类
 */
@Service
public class MatchService {

    @Resource
    private MatchMapper matchMapper;

    @Resource
    private ClubMapper clubMapper;

    @Resource
    private MatchEnterMapper matchEnterMapper;

    @Resource
    private MatchMemberMapper matchMemberMapper;

    public List<Match> selectAll(){
        return matchMapper.selectAll();
    }

    public Match selectById(Integer id){
        return matchMapper.selectById(id);
    }

    public void insert(Match match){
        matchMapper.insert(match);
    }

    public void update(Match match){
        matchMapper.update(match);
    }

    public void deleteById(Integer id){
        matchMapper.deleteById(id);
    }

    public List<MatchModel> selectAllMatchModel(){
        List<MatchModel> matchModelList = new ArrayList<>();
        List<Match> matchList = matchMapper.selectAll();
        if(matchList!=null&&matchList.size()>0){
            for(Match match : matchList){
                MatchModel matchModel = new MatchModel();
                matchModel.setMatch(match);
                matchModel.setClub(clubMapper.selectById(match.getClubId()));
                matchModel.setMatchEnterList(matchEnterMapper.selectByMatchId(match.getId()));
                matchModel.setMatchMemberList(matchMemberMapper.selectByMatchId(match.getId()));
                matchModelList.add(matchModel);
            }
        }
        return matchModelList;
    }

    public MatchModel selectMatchModelbyId(Integer id){
        MatchModel matchModel = new MatchModel();
        Match match = matchMapper.selectById(id);
        matchModel.setMatch(match);
        matchModel.setClub(clubMapper.selectById(match.getClubId()));
        matchModel.setMatchEnterList(matchEnterMapper.selectByMatchId(match.getId()));
        matchModel.setMatchMemberList(matchMemberMapper.selectByMatchId(match.getId()));
        return matchModel;
    }
}
