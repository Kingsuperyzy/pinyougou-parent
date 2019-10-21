package com.pinyougou.pinyougouweb.Address;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author:zkx
 * create:time:2019/10/20
 * email:
 * tel:
 */
@Controller
@RequestMapping("page")
public class AddressPageController {

    @RequestMapping("address")
    public String address(){
        return "home-setting-address";
    }
    @RequestMapping("add")
    public String add(){
        return "home-setting-address-add";
    }

}
