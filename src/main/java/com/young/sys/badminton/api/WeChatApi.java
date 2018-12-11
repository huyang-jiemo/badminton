package com.young.sys.badminton.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.young.sys.badminton.domain.User;
import com.young.sys.badminton.model.AjaxResult;
import com.young.sys.badminton.model.Constant;
import com.young.sys.badminton.service.UserService;
import com.young.sys.badminton.util.PasswordUtil;
import com.young.sys.badminton.util.WeChatUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author huyang8
 * // TODO: 2018/12/06  微信端controller
 */
@Controller
@RequestMapping("/api/wechat")
public class WeChatApi extends BaseApi{

    @Resource
    private UserService userService;

    @RequestMapping("/login.do")
    @ResponseBody
    public AjaxResult login(String code,String nick,String avatar,Integer sex,String city,String province){
        String jstr = WeChatUtil.getConvert(code);
        JSONObject obj = JSON.parseObject(jstr);
        String openid = obj.get("openid").toString();
        User user = userService.selectByOpenid(openid);
        if(user==null){
            User userSave = new User();
            userSave.setOpenid(openid);
            userSave.setNick(nick);
            userSave.setAccount(openid);
            userSave.setSex(sex);
            userSave.setAvatar(avatar);
            userSave.setPwd(PasswordUtil.getInstance().XORencode(Constant.DEFAULT_PWD,Constant.KEY_CODE));
            userSave.setAvatar(avatar);
            userSave.setRole(0);
            userSave.setProvince(province);
            userSave.setCity(city);
            userService.insert(userSave);
            return successData(userService.selectByOpenid(openid));
        }else{
            return successData(user);
        }
    }
}
