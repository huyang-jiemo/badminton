package com.young.sys.meetoo.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.young.sys.badminton.domain.User;
import com.young.sys.badminton.model.AjaxResult;
import com.young.sys.badminton.service.UserService;
import com.young.sys.badminton.util.DateUtil;
import com.young.sys.badminton.util.WeChatUtil;
import com.young.sys.meetoo.domain.MeetooUser;
import com.young.sys.meetoo.domain.MeetooUserRelation;
import com.young.sys.meetoo.service.MeetooUserRelationService;
import com.young.sys.meetoo.service.MeetooUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 *
 * @author huyang8
 * @date 2019-01-23 16:53
 */
@Controller
@RequestMapping("/api/meetoo/user")
public class MeetooUserApi extends MeetooBaseApi {

    private static final String APPID = "wx9b93f178992ef513";

    private static final String APPSECRET = "08bd5d7978f0ea5824bb6e22e7b3302d";

    @Resource
    private MeetooUserService meetooUserService;

    @Resource
    private MeetooUserRelationService meetooUserRelationService;

    @Resource
    private UserService userService;

    @RequestMapping("/register.do")
    @ResponseBody
    public AjaxResult register(String jsCode){
        String data = WeChatUtil.getConvert(jsCode,APPID,APPSECRET);
        JSONObject obj = JSON.parseObject(data);
        String openid = String.valueOf(obj.get("openid"));
        MeetooUser meeTooUser = meetooUserService.selectByOpenId(openid);
        if(meeTooUser==null){
            meeTooUser = new MeetooUser();
            meeTooUser.setOpenid(openid);
            meeTooUser.setNick("用户");
            meeTooUser.setSignature("在每一天的清晨都能发现遇喔精彩时刻！");
            meeTooUser.setCreateTime(DateUtil.getNow());
            meetooUserService.insert(meeTooUser);
        }
        return successData(meeTooUser);
    }

    @RequestMapping("/login.do")
    @ResponseBody
    public AjaxResult login(MeetooUser meetooUser){
        MeetooUser meetooUserDB = meetooUserService.selectByOpenId(meetooUser.getOpenid());
        if(meetooUserDB==null){
            User user = userService.selectByOpenid(meetooUser.getOpenid());
            if(user!=null){
                meetooUserDB = new MeetooUser();
                meetooUserDB.setOpenid(meetooUser.getOpenid());
                meetooUserDB.setNick("用户");
                meetooUserDB.setSignature("在每一天的清晨都能发现遇喔精彩时刻！");
                meetooUserDB.setCreateTime(DateUtil.getNow());
                meetooUserService.insert(meetooUserDB);
            }
        }
        return successData(meetooUserService.selectByOpenId(meetooUser.getOpenid()));
    }

    @RequestMapping("/getUserInfo.do")
    @ResponseBody
    public AjaxResult getUserInfo(Integer userId){
        return successData(meetooUserService.selectById(userId));
    }

    @RequestMapping("/access.do")
    @ResponseBody
    public AjaxResult access(MeetooUser meetooUser){
        MeetooUser meetooUserDB = meetooUserService.selectByOpenId(meetooUser.getOpenid());
        if(meetooUserDB==null){
            User user = userService.selectByOpenid(meetooUser.getOpenid());
            if(user!=null){
                meetooUserDB = new MeetooUser();
                meetooUserDB.setOpenid(meetooUser.getOpenid());
                meetooUserDB.setNick("用户");
                meetooUserDB.setSignature("在每一天的清晨都能发现遇喔精彩时刻！");
                meetooUserDB.setCreateTime(DateUtil.getNow());
                meetooUserService.insert(meetooUserDB);
            }
            meetooUserDB = meetooUserService.selectByOpenId(meetooUser.getOpenid());
        }
        meetooUserDB.setNick(meetooUser.getNick());
        if(meetooUser.getSex()!=null){
            meetooUserDB.setSex(meetooUser.getSex());
        }
        meetooUserDB.setAvatar(meetooUser.getAvatar());
        meetooUserDB.setProvince(meetooUser.getProvince());
        meetooUserDB.setCity(meetooUser.getCity());
        meetooUserService.update(meetooUserDB);
        return successData(meetooUserDB);
    }

    @RequestMapping("/selectUserStatistic.do")
    @ResponseBody
    public AjaxResult selectUserStatistic(Integer userId){
        return successData(meetooUserService.selectUserStatistic(userId));
    }

    @RequestMapping("/updateProfile.do")
    @ResponseBody
    public AjaxResult updateProfile(MeetooUser meetooUser){
        MeetooUser meeTooUserDB = meetooUserService.selectById(meetooUser.getId());
        if(meeTooUserDB!=null){
            meeTooUserDB.setNick(meetooUser.getNick());
            meeTooUserDB.setSex(meetooUser.getSex());
            meeTooUserDB.setProvince(meetooUser.getProvince());
            meeTooUserDB.setCity(meetooUser.getCity());
            meeTooUserDB.setConstellation(meetooUser.getConstellation());
            meeTooUserDB.setSignature(meetooUser.getSignature());
            meetooUserService.update(meeTooUserDB);
        }
        return success();
    }

    @RequestMapping("/isFan.do")
    @ResponseBody
    public AjaxResult isFan(Integer fanUserId, Integer followUserId){
        MeetooUserRelation meetooUserRelation = meetooUserRelationService.selectIsFan(fanUserId,followUserId);
        if(meetooUserRelation!=null){
            return success();
        }else{
            return failMessage(null);
        }
    }

    @RequestMapping("/saveUserRelation.do")
    @ResponseBody
    public AjaxResult saveUserRelation(Integer fanUserId, Integer followUserId){
        if(fanUserId.compareTo(followUserId)==0){
            return failMessage("您时刻关注着你自己！");
        }
        MeetooUserRelation meetooUserRelationDB = meetooUserRelationService.selectIsFan(fanUserId,followUserId);
        if(meetooUserRelationDB!=null){
            return failMessage("您已经关注对方啦！");
        }
        MeetooUserRelation meetooUserRelation = new MeetooUserRelation();
        meetooUserRelation.setFanUserId(fanUserId);
        meetooUserRelation.setFollowUserId(followUserId);
        meetooUserRelation.setCreateTime(DateUtil.getNow());
        meetooUserRelationService.insert(meetooUserRelation);
        return success();
    }

    @RequestMapping("/deleteRelation.do")
    @ResponseBody
    public AjaxResult deleteRelation(Integer fanUserId, Integer followUserId){
        meetooUserRelationService.deleteRelation(fanUserId,followUserId);
        return success();
    }

    @RequestMapping("/selectUserFollows.do")
    @ResponseBody
    public AjaxResult selectUserFollows(Integer userId){
        return successData(meetooUserRelationService.selectUserFollows(userId));
    }

    @RequestMapping("/selectUserFans.do")
    @ResponseBody
    public AjaxResult selectUserFans(Integer userId){
        return successData(meetooUserRelationService.selectUserFans(userId));
    }
}
