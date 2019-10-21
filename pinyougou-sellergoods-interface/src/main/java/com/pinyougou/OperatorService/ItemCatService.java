package com.pinyougou.OperatorService;

import java.util.HashMap;

public interface ItemCatService {
    /**
     *
     * @param page
     * @param rows
     * @return
     * 查询商品分类
     * 运营商后台系统--商品分类管理模块
     */
    HashMap<String, Object> queryItemCatPageData(int page, int rows);
}
