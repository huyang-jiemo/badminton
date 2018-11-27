package com.young.sys.badminton.api;

import com.young.sys.badminton.model.AjaxResult;
import com.young.sys.badminton.service.ClubService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author huyang8
 * // TODO: 2018/10/9  俱乐部controller
 */
@Controller
@RequestMapping("/api/club")
public class ClubApi extends BaseApi{

    @Resource
    private ClubService clubService;

    @RequestMapping("/query.do")
    @ResponseBody
    public AjaxResult query(){
        return successData(clubService.selectAll());
    }

    @RequestMapping("/queryById.do")
    @ResponseBody
    public AjaxResult queryById(Integer id){
        return successData(clubService.selectApiModelById(id));
    }
}
