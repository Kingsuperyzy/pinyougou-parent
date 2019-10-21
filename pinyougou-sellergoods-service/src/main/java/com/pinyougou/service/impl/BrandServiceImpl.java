package com.pinyougou.service.impl;

import com.alibaba.dubbo.config.annotation.Service;

import com.pinyougou.OperatorService.BrandService;
import com.pinyougou.mapper.BrandDao;

import com.pinyougou.pojo.TbBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: pinyougou-parent
 * @description:
 * @author: yzh
 * @create: 2019-10-18 21:25
 */
@Service
@Component
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandDao brandDao;
    @Override
    public HashMap<String, Object> queryBrandPageData(int page, int rows) {
        HashMap<String, Object> map=new HashMap<>();
        int count=brandDao.queryBrandCount(page,rows);
        map.put("total",count);
        int start=(page-1)*rows;
        List<TbBrand> list=brandDao.queryBrandPageData(start,rows);
        map.put("rows",list);
        return map;
    }

    @Override
    public void addBrank(TbBrand tbBrand) {
        if(tbBrand.getId()==null){
            brandDao.addBrank(tbBrand);
        }else{
            brandDao.updateBrand(tbBrand);
        }

    }

    @Override
    public TbBrand findBrandById(Integer id) {
        return brandDao.findBrandById(id);
    }

    @Override
    public void delBrand(Integer[] ids) {
        brandDao.delBrand(ids);
    }

    @Override
    public List<Map> selectOptionList() {
        return brandDao.selectOptionList();
    }
}
