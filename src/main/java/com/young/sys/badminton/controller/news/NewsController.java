package com.young.sys.badminton.controller.news;

import com.young.sys.badminton.controller.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huyang8
 * // TODO: 2018/10/9  资讯controller
 */
@Controller
@RequestMapping("")
public class NewsController extends BaseController {

    /**
     * 跳转主页
     */
    @RequestMapping("/news.do")
    public String index(){
        return "/news/index";
    }
}
