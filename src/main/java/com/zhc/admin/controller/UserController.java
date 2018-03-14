package com.zhc.admin.controller;

import com.zhc.admin.pojo.User;
import com.zhc.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/*
 * 用户注册登录控制器
 */
@Controller
public class UserController {

    /*
      自动注入userService
     */
    @Autowired
    private UserService userService;
    /**
     * @Author : zhc
     * @Decription: 登陆界面
     * @return : string
     * @Date : 10:39 2017/12/27 0027
     */
    @RequestMapping("admin")
    public String loginPage() {
        return "admin/login";
    }

    /**
     * @Author zhc
     * @Decription 验证用户名密码是否匹配
     * @param username
     * @param password
     * @return : true:匹配 false：不匹配
     * @Date : 10:39 2017/12/27 0027
     */
    @RequestMapping("loginCheck")
    @ResponseBody
    public boolean loginCheck(@RequestParam("username")String username,
                               @RequestParam("password")String password){
        User user = userService.login(username);
        if(user.getPassword().equals(password)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * @Author : zhc
     * @Decription: 登陆成功
     * @return 登陆成功转发后台页面  失败返回登陆页面重新登陆
     * @Date : 10:40 2017/12/27 0027
     */
    @RequestMapping("admin/index")
    public ModelAndView loginAction(@RequestParam("username")String username,
                               @RequestParam("password")String password,
                                    HttpSession session) {
        User user = userService.login(username);
        ModelAndView mv = new ModelAndView();
        if(user.getPassword().equals(password)){
            session.setAttribute("user", user);
            mv.setViewName("redirect:article/index");
        }
        else{
            mv.setViewName("redirect:admin");
        }
        return mv;
    }
    /**
     * @Author : zhc
     * @Decription: 注册页面
     * @return 注册页面
     * @Date : 10:50 2017/12/27 0027
     */
    @RequestMapping("regist")
    public String registPage(){
        return "admin/regist";
    }

    /**
     * @Author : zhc
     * @Decription: 保存用户信息
     * @param user 对象
     * @return : 登陆界面
     * @Date : 11:06 2017/12/27 0027
     */
    @RequestMapping("register")
    public ModelAndView register(User user) {
        ModelAndView mv = new ModelAndView();
        userService.save(user);
        mv.setViewName("redirect:admin");
        return mv;
    }

    /**
     * @Author : zhc
     * @Decription: 检测用户名是否被占用
     * @param username
     * @return : boolean
     * @Date : 12:21 2017/12/27 0027
     */
    @RequestMapping("checkUsername")
    @ResponseBody
    public boolean checkUsername(@RequestParam("username")String username) {
        User user = userService.login(username);
        if(user != null)
            return true;
        else
            return false;
    }

    @RequestMapping("admin/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/";
    }
}
