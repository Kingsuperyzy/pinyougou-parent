package com.pinyougou.shop.mapper;


import com.pinyougou.pojo.TbGoods;
import com.pinyougou.pojo.TbSeller;
import com.pinyougou.pojo.TbUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: pinyougou-parent
 * @author: yzy
 * @create: 2019-10-19 16:08
 **/
@Mapper
@Repository
public interface ShopMapper {

    TbSeller findUserByName(@Param("username") String username);

    int queryGoodsCount(@Param("goods") TbGoods goods);

    List<TbGoods> queryGoods(@Param("start") int start, @Param("rows") Integer rows, @Param("goods") TbGoods goods);

    String deleteAll(@Param("gid") String[] id);

    TbUser queryUserName(@Param("user") String username);

    void zhuce(TbUser u);
}
