package com.young.sys.badminton.controller.match;

import com.young.sys.badminton.controller.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author huyang8
 * // TODO: 2018/10/9  比赛controller
 */
@Controller
@RequestMapping("")
public class MatchController extends BaseController {

    /**
     * 跳转主页
     */
    @RequestMapping("/match.do")
    public String index(){
        return "/match/index";
    }

    @RequestMapping("/match/organizeMatch.do")
    public String organizeMatch(){
        return "/match/organize";
    }

    @RequestMapping("/match/saveMatchAdd.do")
    public ModelAndView saveMatchAdd(Integer clubId,String matchName,String matchAddress,
                                     Integer menSingle,Integer womenSingle,Integer menDouble,Integer womenDouble,Integer mixDouble,
                                     String startDate,String endDate,String startTime,String endTime,
                                     Integer limitMember,String matchMemo){


        return new ModelAndView(new RedirectView("/match.do"));
    }
}
