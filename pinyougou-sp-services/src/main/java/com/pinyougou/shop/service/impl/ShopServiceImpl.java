package com.pinyougou.shop.service.impl;/**
 * @program: pinyougou-parent
 * @author: yzy
 * @create: 2019-10-19 16:06
 **/

import com.alibaba.dubbo.config.annotation.Service;

import com.pinyougou.pojo.TbGoods;
import com.pinyougou.pojo.TbSeller;
import com.pinyougou.pojo.TbUser;
import com.pinyougou.shop.mapper.ShopMapper;
import com.pinyougou.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 *@ClassName ShopServiceImpl
 *@Author yzy
 *@Date 2019/10/19 16:06
 */
@Service
@Component
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public TbSeller findUserByName(String username) {

        return shopMapper.findUserByName(username);

    }

    @Override
    public HashMap<String, Object> queryGoods(Integer page, Integer rows, TbGoods goods) {
        HashMap<String, Object> map = new HashMap<>();
        int count =shopMapper.queryGoodsCount(goods);
        map.put("total",count);
        int start = (page-1)*rows;
        List<TbGoods> list = shopMapper.queryGoods(start,rows,goods);
        map.put("rows",list);
        return map;
    }

    @Override
    public String deleteAll(String[] id) {
        return shopMapper.deleteAll(id);
    }

    @Override
    public TbUser queryUserName(String username) {
        return shopMapper.queryUserName(username);
    }

    /*@Override
    public void zhuce(TbUser u) {
        shopMapper.zhuce(u);
    }*/
}
