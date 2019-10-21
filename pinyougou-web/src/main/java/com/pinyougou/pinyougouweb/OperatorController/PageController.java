package com.pinyougou.pinyougouweb.OperatorController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: pinyougou-parent
 * @description:
 * @author: yzh
 * @create: 2019-10-18 22:27
 */
@Controller
@RequestMapping("page")
public class PageController {


    @RequestMapping("toItemCat")
    public String toItemCat(){
        return "item_cat";
    }
    @RequestMapping("typeTemplate")
    public String typeTemplate(){
        return "type_template";
    }

    /**
     * 去品牌管理页面
     * @return
     */
    @RequestMapping("tobrand")
    public String tobrand(){
        return "brand";
    }

 

   
     /**
     * 去home页面
     * @return
     */

    @RequestMapping("tohome")
    public String tohome(){
        return "home.html";
    }

    /**
     * 去新增品牌管理页面
     * @return
     */
    @RequestMapping("toAdd")
    public String toAdd(){
        return "addBrands.html";
    }

    /**
     * 去规格管理页面
     * @return
     */
    @RequestMapping("tospecification")
    public String tospecification(){
        return "specification.html";
    }

    @RequestMapping("toAddSpecification")
    public String toAddSpecification(){
        return "addSpecification.html";
    }

}
