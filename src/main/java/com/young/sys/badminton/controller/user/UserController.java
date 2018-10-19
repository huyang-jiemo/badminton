package com.young.sys.badminton.controller.user;

import com.young.sys.badminton.controller.base.BaseController;
import com.young.sys.badminton.domain.User;
import com.young.sys.badminton.model.AjaxResult;
import com.young.sys.badminton.model.Constant;
import com.young.sys.badminton.service.UserService;
import com.young.sys.badminton.util.FileUploadUtil;
import com.young.sys.badminton.util.PasswordUtil;
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
 * // TODO: 2018/10/9  用户相关controller
 */
@Controller
@RequestMapping("")
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    /**
     * 跳转主页
     */
    @RequestMapping("/user/index.do")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        List<User> userList = userService.selectAll();
        mv.addObject("userList",userList);
        mv.setViewName("/user/index");
        return mv;
    }

    @RequestMapping("/user/saveUserAdd.do")
    public ModelAndView saveUserAdd(String account, String nick, Integer sex, Long phone, String pwd,
                                    @RequestParam(value = "avatar", required = false) MultipartFile file, HttpServletRequest request){
        User user = new User();
        user.setAccount(account);
        user.setNick(nick);
        user.setSex(sex);
        user.setPhone(phone);
        user.setPwd(PasswordUtil.getInstance().XORencode(pwd,Constant.KEY_CODE));
        user.setAvatar(FileUploadUtil.uploadFile(file,request,"user"));
        user.setRole(0);
        userService.insert(user);
        return new ModelAndView(new RedirectView("/user/index.do"));
    }

    /**
     * 跳转编辑页
     */
    @RequestMapping("/user/edit.do")
    public ModelAndView edit(Integer id){
        ModelAndView mv = new ModelAndView();
        User user = userService.selectById(id);
        mv.addObject("user",user);
        mv.setViewName("/user/edit");
        return mv;
    }

    @RequestMapping("/user/saveUserEdit.do")
    public ModelAndView saveUserEdit(Integer id,String account, String nick, Integer sex, Long phone, String pwd,String avatarUrl,
                                    @RequestParam(value = "avatar", required = false) MultipartFile file, HttpServletRequest request){
        User user = userService.selectById(id);
        if(!user.getAccount().equals(account)){
            user.setAccount(account);
        }
        if(!user.getNick().equals(nick)){
            user.setNick(nick);
        }
        if(user.getSex().compareTo(sex)!=0){
            user.setSex(sex);
        }
        if(!user.getPhone().equals(phone)){
            user.setPhone(phone);
        }
        if(!user.getPwd().equals(pwd)){
            user.setPwd(PasswordUtil.getInstance().XORencode(pwd,Constant.KEY_CODE));
        }
        if(StringUtils.isEmpty(avatarUrl)||!user.getAvatar().equals(avatarUrl)){
            user.setAvatar(FileUploadUtil.uploadFile(file,request,"user"));
        }
        userService.update(user);
        return new ModelAndView(new RedirectView("/user/index.do"));
    }

    /**
     * 删除
     */
    @RequestMapping("/user/delete.do")
    public ModelAndView delete(Integer id){
        ModelAndView mv = new ModelAndView();
        userService.deleteById(id);
        return new ModelAndView(new RedirectView("/user/index.do"));
    }

    @RequestMapping("/user/userSelect.do")
    @ResponseBody
    public AjaxResult getUserSelect(){
        List<User> userList = userService.selectAll();
        return successData(userList);
    }
}
