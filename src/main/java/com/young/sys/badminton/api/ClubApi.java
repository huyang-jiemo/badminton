package com.young.sys.badminton.api;

import com.young.sys.badminton.domain.Club;
import com.young.sys.badminton.domain.ClubMember;
import com.young.sys.badminton.domain.User;
import com.young.sys.badminton.model.AjaxResult;
import com.young.sys.badminton.service.ClubMemberService;
import com.young.sys.badminton.service.ClubService;
import com.young.sys.badminton.service.UserService;
import com.young.sys.badminton.util.FileUploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author huyang8
 * TODO: 2018/12/06  俱乐部api
 */
@Controller
@RequestMapping("/api/club")
public class ClubApi extends BaseApi {

    @Resource
    private ClubService clubService;

    @Resource
    private UserService userService;

    @Resource
    private ClubMemberService clubMemberService;

    @RequestMapping("/apply.do")
    @ResponseBody
    public AjaxResult apply(String clubName, Integer userId, String clubMemo, String clubAddress, String clubPhone) {
        Club club = new Club();
        club.setClubName(clubName);
        club.setUserId(userId);
        club.setClubMemo(clubMemo);
        club.setClubAddress(clubAddress);
        club.setClubPhone(clubPhone);
        clubService.insert(club);
        User user = userService.selectById(userId);
        user.setRole(2);//将用户置为俱乐部会长
        userService.update(user);
        //插入成员表
        Club clubDB = clubService.selectByUserId(userId);
        ClubMember clubMember = new ClubMember();
        clubMember.setClubId(clubDB.getId());
        clubMember.setUserId(userId);
        clubMember.setMemberLevel(0);
        clubMemberService.insert(clubMember);
        return success();
    }

    @RequestMapping("/uploadLogo.do")
    @ResponseBody
    public AjaxResult uploadLogo(Integer userId,HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file) {
        Club club = clubService.selectByUserId(userId);
        club.setClubLogo(FileUploadUtil.uploadFile(file, request, "club"));
        clubService.update(club);
        return success();
    }

    @RequestMapping("/selectByUserId.do")
    @ResponseBody
    public AjaxResult selectByUserId(Integer userId) {
        return successData(clubService.selectByUserId(userId));
    }

    @RequestMapping("/selectAll.do")
    @ResponseBody
    public AjaxResult selectAll() {
        return successData(clubService.selectAll());
    }

    @RequestMapping("/selectById.do")
    @ResponseBody
    public AjaxResult selectById(Integer id) {
        return successData(clubService.selectById(id));
    }

    @RequestMapping("/selectModelById.do")
    @ResponseBody
    public AjaxResult selectModelById(Integer id) {
        return successData(clubService.selectModelById(id));
    }

    @RequestMapping("/selectModelByUserId.do")
    @ResponseBody
    public AjaxResult selectModelByUserId(Integer userId) {
        return successData(clubService.selectModelByUserId(userId));
    }

    @RequestMapping("/selectAllClubModel.do")
    @ResponseBody
    public AjaxResult selectAllClubModel() {
        return successData(clubService.selectAllClubModel());
    }
}
