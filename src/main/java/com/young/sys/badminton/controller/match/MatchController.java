package com.young.sys.badminton.controller.match;

import com.young.sys.badminton.controller.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
