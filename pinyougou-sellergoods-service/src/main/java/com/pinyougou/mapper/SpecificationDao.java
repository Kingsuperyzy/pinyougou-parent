package com.pinyougou.mapper;


import com.pinyougou.pojo.TbSpecification;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: pinyougou-parent
 * @description:
 * @author: yzh
 * @create: 2019-10-19 19:11
 */
@Mapper
@Repository
public interface SpecificationDao {
    int querySpecificationCount(@Param("tbSpecification") TbSpecification tbSpecification);

    List<TbSpecification> querySpecificationPageData(@Param("start")int start,@Param("rows") int rows,@Param("tbSpecification") TbSpecification tbSpecification);
}
