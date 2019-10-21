package com.pinyougou.mapper.OperatorDao;


import com.pinyougou.pojo.TbItemCat;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ItemCatDao {


    /**
     *
     * @param
     * @param
     * @return
     * 查询商品分类
     * 运营商后台系统--商品分类管理模块
     */

    int findItemCatCount();

    List<TbItemCat> findItemCatList(Integer start, int rows);

}
