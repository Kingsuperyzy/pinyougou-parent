package com.pinyougou.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.mapper.AddressDao;
import com.pinyougou.pojo.TbAddress;
import com.pinyougou.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * author:zkx
 * create:time:2019/10/19
 * email:
 * tel:
 */
@Service
@Component
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;

    @Override
    public List<TbAddress> findAddRessList() {
        return addressDao.findAddRessList();
    }

    @Override
    public void deleteAll(Integer ids) {
        addressDao.deleteAll(ids);
    }

    @Override
    public void addAddress(TbAddress address) {
        Long id = address.getId();
        if(id!=null){//修改
            addressDao.updateAddress(address);
        }else{//新增
            addressDao.addAddress(address);
        }
    }

    @Override
    public TbAddress queryById(Integer id) {
        return addressDao.queryById(id);
    }
}
