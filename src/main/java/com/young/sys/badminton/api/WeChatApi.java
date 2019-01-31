package com.young.sys.badminton.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.young.sys.badminton.domain.User;
import com.young.sys.badminton.model.AjaxResult;
import com.young.sys.badminton.service.UserService;
import com.young.sys.badminton.util.WeChatUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author huyang8
 * // TODO: 2018/12/06  微信端api
 */
@Controller
@RequestMapping("/api/wechat")
public class WeChatApi extends BaseApi{

    private static final String APPID = "wx9b93f178992ef513";

    private static final String APPSECRET = "08bd5d7978f0ea5824bb6e22e7b3302d";

    @Resource
    private UserService userService;

    @RequestMapping("/register.do")
    @ResponseBody
    public AjaxResult register(String openid){
        User userDB = userService.selectByOpenid(openid);
        if(userDB==null){
            User user = new User();
            user.setOpenid(openid);
            user.setRole(1);
            userService.insert(user);
            return successData(userService.selectByOpenid(openid));
        }else{
            return successData(userDB);
        }
    }

    @RequestMapping("/login.do")
    @ResponseBody
    public AjaxResult login(String openid,String nick,String avatar,Integer sex){
        User userDB = userService.selectByOpenid(openid);
        if(userDB==null){
            User userSave = new User();
            userSave.setOpenid(openid);
            userSave.setNick(nick);
            userSave.setSex(sex);
            userSave.setAvatar(avatar);
            userSave.setRole(1);
            userService.insert(userSave);
            return successData(userService.selectByOpenid(openid));
        }else{
            userDB.setNick(nick);
            userDB.setSex(sex);
            userDB.setAvatar(avatar);
            userService.update(userDB);
            return successData(userDB);
        }
    }

    @RequestMapping("/getOpenId.do")
    @ResponseBody
    public AjaxResult getOpenId(String jsCode){
        String data = WeChatUtil.getConvert(jsCode,APPID,APPSECRET);
        JSONObject obj = JSON.parseObject(data);
        String openid = (String) obj.get("openid");
        return successData(openid);
    }
}
