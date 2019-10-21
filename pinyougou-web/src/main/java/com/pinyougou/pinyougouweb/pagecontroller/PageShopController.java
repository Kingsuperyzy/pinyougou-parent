package com.pinyougou.pinyougouweb.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pageShop")
public class PageShopController {
    @RequestMapping("toshoplogin")
    public String toLogin(){

        return "shoplogin";
    }

    @RequestMapping("toSeller")
    public String toSeller(){

        return "seller";
    }
    @RequestMapping("toSeller1")
    public String toSeller1(){

        return "seller_1";
    }


    @RequestMapping("toshopindex")
    public String toshopindex(){

        return "shopindex";
    }

    @RequestMapping("toGoods")
    public String toGoods(){

        return "goods";
    }

}
