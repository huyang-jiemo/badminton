package com.young.sys.badminton.controller.match;

import com.young.sys.badminton.controller.base.BaseController;
import com.young.sys.badminton.domain.Match;
import com.young.sys.badminton.domain.MatchEnter;
import com.young.sys.badminton.domain.MatchMember;
import com.young.sys.badminton.model.MatchModel;
import com.young.sys.badminton.service.MatchEnterService;
import com.young.sys.badminton.service.MatchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huyang8
 * // TODO: 2018/10/9  比赛controller
 */
@Controller
@RequestMapping("")
public class MatchController extends BaseController {

    @Resource
    private MatchService matchService;

    @Resource
    private MatchEnterService matchEnterService;

    /**
     * 跳转主页
     */
    @RequestMapping("/match.do")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        List<MatchModel> matchModelList = matchService.selectAllMatchModel();
        mv.addObject("matchModelList",matchModelList);
        mv.setViewName("/match/index");
        return mv;
    }

    /**
     * 详情页
     */
    @RequestMapping("/match/seeMatchDetail.do")
    public ModelAndView seeMatchDetail(Integer id){
        ModelAndView mv = new ModelAndView();
        MatchModel matchModel = matchService.selectMatchModelbyId(id);
        mv.addObject("matchModel",matchModel);
        mv.setViewName("/match/detail");
        return mv;
    }

    @RequestMapping("/match/organizeMatch.do")
    public String organizeMatch(){
        return "/match/organize";
    }

    @RequestMapping("/match/saveMatchAdd.do")
    public ModelAndView saveMatchAdd(Integer clubId,String matchName,String matchAddress,
                                     String menSingle,String womenSingle,String menDouble,String womenDouble,String mixDouble,
                                     String startDate,String endDate,String startTime,String endTime,
                                     Integer limitMember,String matchMemo){
        Match match = new Match();
        match.setClubId(clubId);
        match.setMatchName(matchName);
        match.setMatchAddress(matchAddress);
        match.setMenSingle("1".equals(menSingle)?1:0);
        match.setWomenSingle("1".equals(womenSingle)?1:0);
        match.setMenDouble("1".equals(menDouble)?1:0);
        match.setWomenDouble("1".equals(womenDouble)?1:0);
        match.setMixDouble("1".equals(mixDouble)?1:0);
        match.setLimitMember(limitMember);
        match.setMatchMemo(matchMemo);
        match.setStartTime(startDate+" "+startTime);
        match.setEndTime(endDate+" "+endTime);
        matchService.insert(match);
        return new ModelAndView(new RedirectView("/match.do"));
    }

    /**
     * 报名
     */
    @RequestMapping("/match/applyMatch.do")
    public ModelAndView applyMatch(Integer id){
        ModelAndView mv = new ModelAndView();
        MatchModel matchModel = matchService.selectMatchModelbyId(id);
        mv.addObject("matchModel",matchModel);
        mv.setViewName("/match/apply");
        return mv;
    }

    @RequestMapping("/match/saveMatchApply.do")
    public ModelAndView saveMatchApply(MatchEnter matchEnter){
        matchEnterService.insert(matchEnter);
        return new ModelAndView(new RedirectView("/match.do"));
    }

    /**
     * 对阵安排
     */
    @RequestMapping("/match/organizeMatchMember.do")
    public ModelAndView organizeMatchMember(Integer id){
        ModelAndView mv = new ModelAndView();
        MatchModel matchModel = matchService.selectMatchModelbyId(id);
        List<MatchEnter> matchEnterList = matchModel.getMatchEnterList();
        if(matchEnterList!=null&&matchEnterList.size()>0){
            List<MatchEnter> menSingleList = new ArrayList<>();
            List<MatchEnter> womenSingleList = new ArrayList<>();
            List<MatchEnter> menDoubleList = new ArrayList<>();
            List<MatchEnter> womenDoubleList = new ArrayList<>();
            List<MatchEnter> mixDoubleList = new ArrayList<>();
            for(MatchEnter matchEnter : matchEnterList){
                switch (matchEnter.getMatchType()){
                    case 1: menSingleList.add(matchEnter);break;
                    case 2: womenSingleList.add(matchEnter);break;
                    case 3: menDoubleList.add(matchEnter);break;
                    case 4: womenDoubleList.add(matchEnter);break;
                    case 5: mixDoubleList.add(matchEnter);break;
                    default:break;
                }
            }
            mv.addObject("menSingleList",menSingleList);
            mv.addObject("womenSingleList",womenSingleList);
            mv.addObject("menDoubleList",menDoubleList);
            mv.addObject("womenDoubleList",womenDoubleList);
            mv.addObject("mixDoubleList",mixDoubleList);
        }
        mv.addObject("matchModel",matchModel);
        mv.setViewName("/match/organizeMember");
        return mv;
    }
}
