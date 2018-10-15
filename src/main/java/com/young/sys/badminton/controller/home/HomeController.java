package com.young.sys.badminton.controller.home;

import com.young.sys.badminton.controller.base.BaseController;
import com.young.sys.badminton.domain.User;
import com.young.sys.badminton.model.AjaxResult;
import com.young.sys.badminton.model.Constant;
import com.young.sys.badminton.service.UserService;
import com.young.sys.badminton.util.PasswordUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author huyang8
 * // TODO: 2018/10/8  首页controller
 */
@Controller
@RequestMapping("")
public class HomeController extends BaseController {

    @Resource
    private UserService userService;

    /**
     * 登录页
     */
    @RequestMapping("/login.do")
    public String login(HttpServletRequest httpServletRequest){
        //此处由于不会被拦截器拦截，因此在此处校验一遍登录session
        HttpSession session = httpServletRequest.getSession();
        //拦截并校验登录用户TOKEN
        User user = (User) session.getAttribute(Constant.SESSION_KEY);
        if (!ObjectUtils.isEmpty(user)) {
            //校验session是否合法有效
            User findUser=userService.selectByAccount(user.getAccount());
            if(!ObjectUtils.isEmpty(findUser)&&findUser.getPwd().equals(user.getPwd())){
                //验证成功直接去首页
                return "/home/index";
            }
        }
        return "/home/login";
    }

    /**
     * 登录鉴权
     * @param session session
     * @param account 账号
     * @param pwd 密码
     */
    @RequestMapping("/index.do")
    @ResponseBody
    public AjaxResult home(HttpSession session, String account, String pwd){
        User user=userService.selectByAccount(account);
        if(ObjectUtils.isEmpty(user)){
            return failMessage(Constant.NOT_EXIST);
        }
        String encryptPwd = PasswordUtil.getInstance().XORencode(pwd,Constant.KEY_CODE);
        //管理员权限
        if(!ObjectUtils.isEmpty(user)&&1==user.getRole()&&encryptPwd.equals(user.getPwd())){
            session.setAttribute(Constant.SESSION_KEY,user);
            return success();
        }
        //验证用户账号是否正确
        if(!ObjectUtils.isEmpty(user)&&!encryptPwd.equals(user.getPwd())){
            return failMessage(Constant.LOGIN_ERROR);
        }else{
            session.setAttribute(Constant.SESSION_KEY,user);
            return success();
        }
    }

    /**
     * 跳转主页
     */
    @RequestMapping("/home.do")
    public String index(){
        return "/home/index";
    }

    /**
     * 退出系统
     */
    @RequestMapping("/logout.do")
    public String logout(HttpSession session){
        //退出系统时清除session
        session.invalidate();
        return "redirect:login.do";
    }
}
