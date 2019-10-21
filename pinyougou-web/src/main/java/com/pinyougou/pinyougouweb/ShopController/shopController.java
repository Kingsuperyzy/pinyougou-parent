package com.pinyougou.pinyougouweb.ShopController;

import com.alibaba.dubbo.config.annotation.Reference;

import com.pinyougou.pojo.TbGoods;
import com.pinyougou.pojo.TbSeller;
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

import java.util.HashMap;

@Controller
@RequestMapping("shop")
public class shopController {
     @Reference
    private ShopService service;

    @Bean(value = "shopService")
    public ShopService getUserService() {

        return service;
    }

     @RequestMapping("shoplogin")
     @ResponseBody
     @RequiresPermissions("shop:shoplogin")
    public String shoplogin(TbSeller seller){
         Subject subject = SecurityUtils.getSubject();
         UsernamePasswordToken upt = new UsernamePasswordToken(seller.getSellerId(), seller.getPassword());
         try{
             subject.login(upt);
             return "登录成功";
         }catch (UnknownAccountException e){
             return "账号不存在";
         }catch (IncorrectCredentialsException e){
             return "密码错误";
         }catch (AuthenticationException e){
             return "用户认证失败";
         }
     }

    @RequestMapping("queryGoods")
    @ResponseBody
    @RequiresPermissions("shop:queryGoods")
    public HashMap<String,Object> queryGoods(Integer page, Integer rows, TbGoods goods){
        return service.queryGoods(page,rows,goods);
    }

    @RequestMapping("deleteAll")
    @ResponseBody
    @RequiresPermissions("shop:deleteAll")
    public String deleteAll(String[] id){
        System.out.println(id);
        return service.deleteAll(id);
    }


}
