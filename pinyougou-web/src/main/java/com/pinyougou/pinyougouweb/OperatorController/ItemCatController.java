package com.pinyougou.pinyougouweb.OperatorController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.OperatorService.ItemCatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("ItemCat")
public class ItemCatController {

    @Reference
    private ItemCatService service;

    /**
     *
     * @param page
     * @param rows
     * @return
     * 查询商品分类
     * 运营商后台系统--商品分类管理模块
     */
    @RequestMapping("queryItemCatPageData")
    @ResponseBody
    public HashMap<String,Object> queryItemCatPageData(int page, int rows){
        return service.queryItemCatPageData(page,rows);
    }

}
