package com.pinyougou.service;



import com.pinyougou.pojo.TbAddress;

import java.util.List;

/**
 * author:zkx
 * create:time:2019/10/19
 * email:
 * tel:
 */
public interface AddressService {

    List<TbAddress> findAddRessList();

    void deleteAll(Integer ids);

    void addAddress(TbAddress address);

    TbAddress queryById(Integer id);
}
