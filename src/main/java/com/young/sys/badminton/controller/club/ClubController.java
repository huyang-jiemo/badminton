package com.young.sys.badminton.controller.club;

import com.young.sys.badminton.controller.base.BaseController;
import com.young.sys.badminton.domain.Club;
import com.young.sys.badminton.domain.User;
import com.young.sys.badminton.model.AjaxResult;
import com.young.sys.badminton.service.ClubService;
import com.young.sys.badminton.service.UserService;
import com.young.sys.badminton.util.FileUploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author huyang8
 * // TODO: 2018/10/9  俱乐部controller
 */
@Controller
@RequestMapping("")
public class ClubController extends BaseController {

    @Resource
    private ClubService clubService;

    @Resource
    private UserService userService;

    /**
     * 跳转主页
     */
    @RequestMapping("/club.do")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        List<Club> clubList = clubService.selectAll();
        mv.addObject("clubList",clubList);
        mv.setViewName("/club/index");
        return mv;
    }

    /**
     * 跳转新增页
     */
    @RequestMapping("/club/clubAdd.do")
    public String clubAdd(){
        return "/club/add";
    }

    @RequestMapping("/club/saveClubAdd.do")
    public ModelAndView saveClubAdd(String clubName, Integer clubUserId, String clubAddress, String clubMemo, String clubQqGroup,
                                  @RequestParam(value = "clubLogo", required = false) MultipartFile file, HttpServletRequest request){
        Club club = new Club();
        club.setClubName(clubName);
        club.setClubUserId(clubUserId);
        club.setClubAddress(clubAddress);
        if(!StringUtils.isEmpty(clubQqGroup)){
            club.setClubQqGroup(clubQqGroup);
        }
        club.setClubMemo(clubMemo);
        club.setClubLogo(FileUploadUtil.uploadFile(file, request, "club"));
        clubService.insert(club);
        return new ModelAndView(new RedirectView("/club.do"));
    }

    @RequestMapping("/club/seeClubMore.do")
    public ModelAndView seeClubMore(Integer id){
        ModelAndView mv = new ModelAndView();
        Club club = clubService.selectById(id);
        mv.addObject("club",club);
        User user = userService.selectById(club.getClubUserId());
        mv.addObject("user",user);
        mv.setViewName("/club/more");
        return mv;
    }

    @RequestMapping("/club/clubSelect.do")
    @ResponseBody
    public AjaxResult getClubSelect(){
        List<Club> clubList = clubService.selectAll();
        return successData(clubList);
    }
}
