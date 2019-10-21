package com.pinyougou.mapper;


import com.pinyougou.pojo.TbAddress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author:zkx
 * create:time:2019/10/19
 * email:
 * tel:
 */
@Mapper
@Component
public interface AddressDao {
    @Select("select * from tb_address")
    List<TbAddress> findAddRessList();

    void deleteAll(Integer ids);

    void updateAddress(TbAddress address);

    void addAddress(TbAddress address);

    TbAddress queryById(Integer id);
}
