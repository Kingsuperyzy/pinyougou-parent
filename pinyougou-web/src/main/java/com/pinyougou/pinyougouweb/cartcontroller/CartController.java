package com.pinyougou.pinyougouweb.cartcontroller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;

import com.pinyougou.pojo.TbUser;
import com.pinyougou.pojo.group.Cart;
import com.pinyougou.service.CartService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import util.CookieUtil;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("cart")
public class CartController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private HttpSession session;

    @Reference(timeout=6000)
    private CartService cartService;

    @RequestMapping("toCart")
    public String cart(){
        return "cart";
    }

    @RequestMapping("toQian")
    public String qian(){
        return "qiantaiindex";
    }

    @RequestMapping("tocartlogin")
    public String tocartlogin(){

        return "cartlogin";
    }

    @RequestMapping("cartlogin")
    @ResponseBody
    public  String login(TbUser u , HttpSession session) {
        TbUser user = cartService.queryUserName(u.getUsername());
        if (user == null) {
            return "用户名不存在";
        }
        if (!u.getPassword().equals(user.getPassword())) {
            return "密码错误";
        }
        session.setAttribute("user","user");
        return "登录成功";
    }



    @RequestMapping("findCartList")
    @ResponseBody
    public List<Cart> findCartList( ) {
        //当前登录人账号

        String cartListString =  util.CookieUtil.getCookieValue(request, "cartList", "UTF-8");

        if (cartListString == null || cartListString.equals("")) {
            cartListString = "[]";
        }
        List<Cart> cartList_cookie = JSON.parseArray(cartListString, Cart.class);
        System.out.println("从cookie中提取购物车");

        return cartList_cookie;

    }

    @RequestMapping("addGoodsToCartList")
    @ResponseBody
    public Result addGoodsToCartList(Long itemId, Integer num){

        try {
            //提取购物车
            List<Cart> cartList = findCartList();
            //调用服务方法操作购物车
            cartList = cartService.addGoodsToCartList(cartList, itemId, num);
                //将新的购物车存入cookie
            String cartListString = JSON.toJSONString(cartList);
            CookieUtil.setCookie(request, response, "cartList", cartListString, 3600*24, "UTF-8");
            System.out.println("向cookie存储购物车");

            return new Result(true, "存入购物车成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "存入购物车失败");
        }


    }


}
