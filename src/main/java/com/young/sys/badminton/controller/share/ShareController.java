package com.young.sys.badminton.controller.share;

import com.young.sys.badminton.controller.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huyang8
 * // TODO: 2018/10/9  共享资源controller
 */
@Controller
@RequestMapping("")
public class ShareController extends BaseController {

    /**
     * 跳转主页
     */
    @RequestMapping("/share.do")
    public String index(){
        return "/share/index";
    }
}
