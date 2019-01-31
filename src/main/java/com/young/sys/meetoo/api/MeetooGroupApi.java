package com.young.sys.meetoo.api;

import com.young.sys.badminton.model.AjaxResult;
import com.young.sys.badminton.util.DateUtil;
import com.young.sys.meetoo.domain.MeetooGroup;
import com.young.sys.meetoo.domain.MeetooGroupMember;
import com.young.sys.meetoo.service.MeetooGroupService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 *
 * @author huyang8
 * @date 2019-01-30 14:46
 */
@Controller
@RequestMapping("/api/meetoo/group")
public class MeetooGroupApi extends MeetooBaseApi{

    @Resource
    private MeetooGroupService meetooGroupService;

    @RequestMapping("/selectByType.do")
    @ResponseBody
    public AjaxResult selectByType(Integer type){
        return successData(meetooGroupService.selectByType(type));
    }

    @RequestMapping("/selectUserGroups.do")
    @ResponseBody
    public AjaxResult selectUserGroups(Integer userId){
        return successData(meetooGroupService.selectUserGroups(userId));
    }

    @RequestMapping("/selectMineGroups.do")
    @ResponseBody
    public AjaxResult selectMineGroups(Integer userId){
        return successData(meetooGroupService.selectMineGroups(userId));
    }

    @RequestMapping("/selectGroupDetail.do")
    @ResponseBody
    public AjaxResult selectGroupDetail(Integer groupId){
        return successData(meetooGroupService.selectById(groupId));
    }

    @RequestMapping("/saveGroup.do")
    @ResponseBody
    public AjaxResult saveGroup(MeetooGroup meetooGroup){
        if(meetooGroup.getId()==null){
            meetooGroup.setCreateTime(DateUtil.getNow());
            meetooGroupService.insert(meetooGroup);
            MeetooGroupMember meetooGroupMember = new MeetooGroupMember();
            meetooGroupMember.setGroupId(meetooGroup.getId());
            meetooGroupMember.setUserId(meetooGroup.getUserId());
            meetooGroupMember.setCreateTime(DateUtil.getNow());
            meetooGroupService.insertMeetooGroupMember(meetooGroupMember);
        }else{
            MeetooGroup meetooGroupDB = meetooGroupService.selectById(meetooGroup.getId());
            meetooGroupDB.setGroupName(meetooGroup.getGroupName());
            meetooGroupDB.setType(meetooGroup.getType());
            meetooGroupDB.setTag(meetooGroup.getTag());
            meetooGroupDB.setIntro(meetooGroup.getIntro());
            meetooGroupService.update(meetooGroupDB);
        }
        return success();
    }

    @RequestMapping("/deleteGroup.do")
    @ResponseBody
    public AjaxResult deleteGroup(Integer groupId){
        meetooGroupService.deleteById(groupId);
        return success();
    }
}
