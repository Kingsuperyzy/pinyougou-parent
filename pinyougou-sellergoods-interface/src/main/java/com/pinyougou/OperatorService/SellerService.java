package com.pinyougou.OperatorService;



import com.pinyougou.pojo.TbSeller;
import entity.PageResult;

import java.util.List;

public interface SellerService {

    List<TbSeller> findAll();

    PageResult findPage(int page, int rows);

    void add(TbSeller seller);

    void update(TbSeller seller);

    TbSeller findOne(String id);

    void delete(String[] ids);

    PageResult findPage(TbSeller seller, int pageNum, int pageSize);

    void updateStatus(String sellerId, String status);
}
