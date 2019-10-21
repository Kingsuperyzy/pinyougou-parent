package com.pinyougou.pinyougouweb.logincontroller;

import com.alibaba.dubbo.config.annotation.Reference;

import com.pinyougou.pojo.TbUser;
import com.pinyougou.shop.service.ShopService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class cartlogincontroller {

    @RequestMapping("toqiantaiindex")
    public String toqiantaiindex(){

        return "qiantaiindex";
    }

    @RequestMapping("tocartlogin")
    public String tocartlogin(){

        return "cartlogin";
    }

    @RequestMapping("tozhuce")
    public String tozhuce(){

        return "register";
    }

    @Reference
    private ShopService service;



    @RequestMapping("cartlogin")
    @ResponseBody

    public  String login(TbUser u) {
        TbUser user = service.queryUserName(u.getUsername());


        if (user == null) {
            return "用户名不存在";
        }if (!u.getPassword().equals(user.getPassword())) {
            return "密码错误";
        }



        return "登录成功";

    }

    /*@RequestMapping("zhuce")
    @ResponseBody
    public String zhuce(TbUser u){
        TbUser user = service.queryUserName(u.getUsername());
        if (user!=null){
            return "用户名已存在";
        }
        service.zhuce(u);
        return "注册成功";
    }*/


}
