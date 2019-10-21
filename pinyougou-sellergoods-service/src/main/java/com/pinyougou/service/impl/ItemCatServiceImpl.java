package com.pinyougou.service.impl;

import com.alibaba.dubbo.config.annotation.Service;

import com.pinyougou.OperatorService.ItemCatService;
import com.pinyougou.mapper.OperatorDao.ItemCatDao;
import com.pinyougou.pojo.TbItemCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Service
@Component
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private ItemCatDao dao;

    /**
     *
     * @param page
     * @param rows
     * @return
     * 查询商品分类
     * 运营商后台系统--商品分类管理模块
     */

    @Override
    public HashMap<String, Object> queryItemCatPageData(int page, int rows) {
        HashMap<String, Object> result = new HashMap<>();
        //查询count
        int count = dao.findItemCatCount();
        result.put("total", count);
        //查询list
        Integer start = (page-1)*rows;
        List<TbItemCat> itemCats = dao.findItemCatList(start,rows);
        result.put("rows", itemCats);
        return result;
    }
}
