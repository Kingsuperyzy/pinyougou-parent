package com.pinyougou.mapper;


import com.pinyougou.pojo.TbBrand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @program: pinyougou-parent
 * @description:
 * @author: yzh
 * @create: 2019-10-18 21:28
 */

@Mapper
@Repository
public interface BrandDao {
    @Select("select count(1) from tb_brand")
    int queryBrandCount(int page, int rows);

    List<TbBrand> queryBrandPageData(@Param("start") int start, @Param("rows")int rows);

    void addBrank( TbBrand tbBrand);


    TbBrand findBrandById(Integer id);

    void updateBrand(TbBrand tbBrand);

    void delBrand(@Param("ids") Integer[] ids);

    List<Map> selectOptionList();
}
