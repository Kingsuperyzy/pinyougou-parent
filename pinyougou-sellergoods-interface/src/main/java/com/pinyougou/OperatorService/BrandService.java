package com.pinyougou.OperatorService;


import com.pinyougou.pojo.TbBrand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: pinyougou-parent
 * @description:
 * @author: yzh
 * @create: 2019-10-18 20:57
 */
public interface BrandService {
    HashMap<String, Object> queryBrandPageData(int page, int rows);

    void addBrank(TbBrand tbBrand);

    TbBrand findBrandById(Integer id);

    void delBrand(Integer[] ids);

    List<Map> selectOptionList();
}
