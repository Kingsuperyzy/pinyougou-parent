package com.pinyougou.pinyougouweb.OperatorController;

import com.alibaba.dubbo.config.annotation.Reference;

import com.pinyougou.OperatorService.BrandService;
import com.pinyougou.pojo.TbBrand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: pinyougou-parent
 * @description:
 * @author: yzh
 * @create: 2019-10-18 20:36
 */

/**
 * 品牌管理层
 */
@Controller
@RequestMapping("brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    /**
     * 分页查询品牌
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("queryBrandPageData")
    @ResponseBody
    public HashMap<String,Object> queryBrandPageData(int page,int rows){
        return brandService.queryBrandPageData(page,rows);
    }

    /**
     * 新增品牌
     * @param tbBrand
     */
    @RequestMapping("addBrank")
    @ResponseBody
    public void addBrank(TbBrand tbBrand){
        brandService.addBrank(tbBrand);
    }

    /**
     * 回显品牌
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("findBrandById")
    public String findBrandById(Integer id, Model model){
        TbBrand tbBrand=brandService.findBrandById(id);
        model.addAttribute("tbBrand",tbBrand);
        return "updateBrands";
    }

    /**
     * 批量删除品牌
     * @param ids
     */
    @RequestMapping("delBrand")
    @ResponseBody
    public void delBrand(Integer[] ids){
        brandService.delBrand(ids);
    }

    /**
     *
     *
     */
    @RequestMapping("selectOptionList")
    @ResponseBody
    public List<Map> selectOptionList(){
        return brandService.selectOptionList();
    }
}
