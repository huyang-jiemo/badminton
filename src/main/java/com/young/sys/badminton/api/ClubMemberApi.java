package com.young.sys.badminton.api;

import com.young.sys.badminton.domain.ClubMember;
import com.young.sys.badminton.domain.User;
import com.young.sys.badminton.model.AjaxResult;
import com.young.sys.badminton.service.ClubMemberService;
import com.young.sys.badminton.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author huyang8
 * TODO: 2018/12/24  俱乐部成员api
 */
@Controller
@RequestMapping("/api/clubMember")
public class ClubMemberApi extends BaseApi{

    @Resource
    private ClubMemberService clubMemberService;

    @Resource
    private UserService userService;

    @RequestMapping("/selectByClubId.do")
    @ResponseBody
    public AjaxResult selectByClubId(Integer clubId) {
        return successData(clubMemberService.selectModelByClubId(clubId));
    }

    @RequestMapping("/selectClubMemberByUserId.do")
    @ResponseBody
    public AjaxResult selectClubMemberByUserId(Integer userId) {
        return successData(clubMemberService.selectByUserId(userId));
    }

    @RequestMapping("/joinClub.do")
    @ResponseBody
    public AjaxResult joinClub(Integer userId,Integer clubId) {
        ClubMember clubMemberDB = clubMemberService.selectByUserId(userId);
        if(clubMemberDB!=null){
            return failMessage(null);
        }
        ClubMember clubMember = new ClubMember();
        clubMember.setClubId(clubId);
        clubMember.setUserId(userId);
        clubMember.setMemberLevel(0);
        clubMemberService.insert(clubMember);
        return success();
    }

    @RequestMapping("/removeMember.do")
    @ResponseBody
    public AjaxResult removeMember(Integer userId,Integer clubId) {
        clubMemberService.removeMember(userId,clubId);
        //将人员角色置为普通成员
        User user = userService.selectById(userId);
        user.setRole(1);
        userService.update(user);
        return success();
    }

    @RequestMapping("/updateMemberLevel.do")
    @ResponseBody
    public AjaxResult updateMemberLevel(ClubMember clubMember) {
        ClubMember clubMemberDB = clubMemberService.selectById(clubMember.getId());
        clubMemberDB.setMemberLevel(clubMember.getMemberLevel());
        clubMemberService.update(clubMemberDB);
        return success();
    }
}
