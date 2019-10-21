package com.pinyougou.shop.service;

import com.pinyougou.pojo.TbGoods;
import com.pinyougou.pojo.TbSeller;
import com.pinyougou.pojo.TbUser;

import java.util.HashMap;

/**
 * @program: pinyougou-parent
 * @author: yzy
 * @create: 2019-10-19 16:05
 **/
public interface ShopService {

    TbSeller findUserByName(String username);

    HashMap<String, Object> queryGoods(Integer page, Integer rows, TbGoods goods);

    String deleteAll(String[] id);

    TbUser queryUserName(String username);


}
